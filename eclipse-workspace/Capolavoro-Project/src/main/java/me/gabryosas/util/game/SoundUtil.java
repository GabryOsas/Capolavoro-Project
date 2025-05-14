package me.gabryosas.util.game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SoundUtil {
	//Classe non sviluppata da me purtroppo... 
	
    private static final List<Clip> activeClips = new CopyOnWriteArrayList<>();
    
    public static void playSound(final String path) {
        new Thread(() -> {
            try {
                File audioFile = new File(path);
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
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
                        if (path.equalsIgnoreCase(ObjectUtil.BACKGROUND_MUSIC_PATH.getString())) {
                        	playSound(ObjectUtil.BACKGROUND_MUSIC_PATH.getString());
                        }
                        if (path.equalsIgnoreCase(ObjectUtil.FINAL_MUSIC_PATH.getString())) {
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
