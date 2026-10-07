# BrainTease Trivia Challenge

BrainTease is a JavaFX desktop trivia game inspired by *Jeopardy!* and *Who Wants to Be a Millionaire?*. Players progress through five rounds, earn points for correct answers, use lifelines, and finish with a timed Lightning Round.

## Features

- Five-round single-player game with a persistent high score
- Randomized question selection for every playthrough
- No repeated displayed question within a game
- Categories covering music, movies and television, video games, world history, U.S. history, science, sports, anime, professional wrestling, geography, food, books, and general knowledge
- Music subcategories including K-Pop, Hip-Hop, R&B, Pop, Rock, and Nu-Metal
- Sports subcategories including soccer, football, baseball, hockey, tennis, golf, and Formula 1
- JavaFX interface with a fixed-size game window and adjustable audio control
- Background music, answer feedback sounds, and a crowd-cheer result effect
- Local best-score storage through Java Preferences

## Rounds

### 1. Multiple Choice

Answer five mixed-category questions. Each correct answer is worth 100 points.

### 2. True or False

Answer five true-or-false questions. Each correct answer is worth 150 points.

### 3. Jeopardy Board

Choose from three randomly selected categories. Each category has $100, $200, and $300 questions. Answered tiles become unavailable and show a check mark.

### 4. Millionaire

Answer five questions with increasing values: $500, $1,000, $2,000, $4,000, and $7,500.

Available lifelines:

- **50:50** removes two incorrect answers.
- **Ask the Audience** shows a percentage breakdown for every option.
- **Phone a Friend** displays spoken advice through a randomly selected installed Windows text-to-speech voice.
- **Walk Away** skips to the Lightning Round with the current score.

### 5. Lightning Round

Answer as many unique questions as possible in 45 seconds. Each correct answer is worth 200 points.

## Requirements

- Windows
- JDK 20
- JavaFX 20.0.1
- PowerShell

The supplied launcher expects JDK 20 at `C:\Program Files\Java\jdk-20` when `JAVA_HOME` is not set. Set `JAVA_HOME` to another JDK 20 installation if needed.

## Running the Game

Open PowerShell in the project folder and run:

```powershell
powershell -ExecutionPolicy Bypass -File .\run-game.ps1
```

The launcher compiles the project, copies its resources, and starts the game. It expects JavaFX libraries in the local Maven cache under `%USERPROFILE%\.m2\repository\org\openjfx`.

## Controls

- Select an answer by clicking it.
- Hover over the speaker icon in the top-right corner to reveal the music-volume slider.
- Use the Millionaire lifeline buttons before selecting an answer.

## Project Structure

```text
src/main/java/com/example/braintease_final/
├── BrainTeaseTriviaGame.java  # JavaFX application and round flow
├── QuestionBank.java          # Categories, question pools, and randomization
├── SoundManager.java          # Music, crowd cheer, and Phone a Friend speech
└── styles.css                 # Application styling

src/main/resources/com/example/braintease_final/
└── crowd-cheer.mp3            # Results-screen cheer effect

run-game.ps1                   # Windows build-and-run launcher
```

## Development Notes

The project uses JavaFX Controls, FXML, and Media. The current UI is built programmatically in `BrainTeaseTriviaGame.java`; legacy FXML files are not required by the current game flow.

## Team

- Damian Metovic — Project Manager, Primary Developer, and Lead Designer of the current BrainTease revamp
- Jiahong Li — Original Technical Lead
- Sowmiya Saveriyan — Original Developer
- Justin Ramirez — Original Quality Assurance
