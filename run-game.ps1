$ErrorActionPreference = 'Stop'

$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$jdkRoot = if ($env:JAVA_HOME) { $env:JAVA_HOME } else { 'C:\Program Files\Java\jdk-20' }
$javac = Join-Path $jdkRoot 'bin\javac.exe'
$java = Join-Path $jdkRoot 'bin\java.exe'

if (!(Test-Path $javac)) {
    throw "Java 20 was not found. Set JAVA_HOME to a JDK 20 installation, then run this script again."
}

$m2 = Join-Path $env:USERPROFILE '.m2\repository\org\openjfx'
$modules = @(
    (Join-Path $m2 'javafx-base\20.0.1\javafx-base-20.0.1-win.jar'),
    (Join-Path $m2 'javafx-graphics\20.0.1\javafx-graphics-20.0.1-win.jar'),
    (Join-Path $m2 'javafx-controls\20.0.1\javafx-controls-20.0.1-win.jar'),
    (Join-Path $m2 'javafx-fxml\20.0.1\javafx-fxml-20.0.1-win.jar'),
    (Join-Path $m2 'javafx-media\20.0.1\javafx-media-20.0.1-win.jar')
)

if ($modules.Where({ !(Test-Path $_) }).Count -gt 0) {
    throw 'JavaFX 20.0.1 is not available in the local Maven cache. Import the project in IntelliJ and allow it to download dependencies first.'
}

$classes = Join-Path $projectRoot 'target\run-classes'
New-Item -ItemType Directory -Force -Path $classes | Out-Null
$sourceFiles = Get-ChildItem (Join-Path $projectRoot 'src\main\java') -Recurse -Filter '*.java' | ForEach-Object FullName
& $javac --module-path ($modules -join ';') -d $classes $sourceFiles
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

Copy-Item (Join-Path $projectRoot 'src\main\resources\*') $classes -Recurse -Force
$packageResources = Join-Path $classes 'com\example\braintease_final'
New-Item -ItemType Directory -Force -Path $packageResources | Out-Null
Copy-Item (Join-Path $projectRoot 'src\main\java\com\example\braintease_final\styles.css') $packageResources -Force
& $java --module-path ($modules -join ';') --add-modules javafx.controls,javafx.fxml,javafx.media -cp $classes com.example.braintease_final.BrainTeaseTriviaGame
