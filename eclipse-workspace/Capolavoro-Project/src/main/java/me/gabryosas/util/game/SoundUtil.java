package me.gabryosas.util.game;

import javax.sound.sampled.*;
import javax.swing.*;
import me.gabryosas.Main;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SoundUtil {
    // Classe non sviluppata da me purtroppo (in parte)...
    private static final List<Clip> activeClips = new CopyOnWriteArrayList<>();

    public static void playSound(final String resourcePath) {
        new Thread(() -> {
            try {
                InputStream audioStream = SoundUtil.class.getResourceAsStream(resourcePath);
                if (audioStream == null) {
                    System.err.println("Risorsa audio non trovata: " + resourcePath);
                    return;
                }

                AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioStream);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                activeClips.add(clip);

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                        activeClips.remove(clip);
                        try {
                            audioIn.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (resourcePath.equals(ObjectUtil.BACKGROUND_MUSIC_PATH.getString()) && Main.OPEN[0]) {
                            playSound(ObjectUtil.BACKGROUND_MUSIC_PATH.getString());
                        }
                        if (resourcePath.equals(ObjectUtil.FINAL_MUSIC_PATH.getString()) && Main.OPEN[1]) {
                            playSound(ObjectUtil.FINAL_MUSIC_PATH.getString());
                        }
                    }
                });

                clip.start();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void stopAllSounds() {
        for (Clip clip : activeClips) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.close();
        }
        activeClips.clear();
    }
}