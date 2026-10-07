package com.example.braintease_final;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/** Lightweight generated audio: no external media files are required. */
final class SoundManager {
    private static boolean musicStarted;
    private static MediaPlayer crowdPlayer;
    private static MidiChannel musicChannel;
    private static double volume = 0.72;

    private SoundManager() { }

    static synchronized void startBackgroundMusic() {
        if (musicStarted) return;
        musicStarted = true;
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            musicChannel = synth.getChannels()[0];
            MidiChannel channel = musicChannel;
            channel.programChange(89); // warm pad
            applyVolume();
            int[] notes = {48, 55, 60, 55, 50, 57, 62, 57};
            ScheduledExecutorService loop = Executors.newSingleThreadScheduledExecutor(r -> {
                Thread thread = new Thread(r, "braintease-music");
                thread.setDaemon(true);
                return thread;
            });
            final int[] beat = {0};
            loop.scheduleAtFixedRate(() -> {
                int note = notes[beat[0]++ % notes.length];
                channel.noteOn(note, 68);
                loop.schedule(() -> channel.noteOff(note), 350, TimeUnit.MILLISECONDS);
            }, 0, 520, TimeUnit.MILLISECONDS);
        } catch (Exception ignored) {
            // The game remains playable on systems without a MIDI device.
        }
    }

    static double getVolume() { return volume; }

    static void setVolume(double newVolume) {
        volume = Math.max(0, Math.min(1, newVolume));
        applyVolume();
        if (crowdPlayer != null) crowdPlayer.setVolume(volume);
    }

    private static void applyVolume() {
        if (musicChannel != null) musicChannel.controlChange(7, (int) Math.round(volume * 100));
    }

    static void playCrowdCheer() {
        try {
            if (crowdPlayer != null) crowdPlayer.stop();
            String source = SoundManager.class.getResource("crowd-cheer.mp3").toExternalForm();
            crowdPlayer = new MediaPlayer(new Media(source));
            crowdPlayer.setVolume(volume);
            crowdPlayer.play();
        } catch (Exception ignored) {
            // Audio hardware is optional.
        }
    }

    static void speakFriend(String text) {
        try {
            String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
            String script = "$text=[Text.Encoding]::UTF8.GetString([Convert]::FromBase64String('" + encoded + "'));"
                    + "Add-Type -AssemblyName System.Speech;$voice=New-Object System.Speech.Synthesis.SpeechSynthesizer;"
                    + "$voices=$voice.GetInstalledVoices();if($voices.Count -gt 0){$voice.SelectVoice($voices[(Get-Random -Maximum $voices.Count)].VoiceInfo.Name)};"
                    + "$voice.Volume=80;$voice.Speak($text);$voice.Dispose();";
            new ProcessBuilder("powershell.exe", "-NoProfile", "-Command", script).start();
        } catch (Exception ignored) {
            // Text remains visible even when Windows speech is unavailable.
        }
    }
}
