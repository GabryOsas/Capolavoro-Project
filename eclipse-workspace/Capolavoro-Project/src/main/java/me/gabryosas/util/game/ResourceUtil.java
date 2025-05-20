package me.gabryosas.util.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class ResourceUtil {
    public static Image loadImage(String resourcePath) {
        try {
            InputStream is = ResourceUtil.class.getResourceAsStream(resourcePath);
            if (is != null) {
                Image image = ImageIO.read(is);
                is.close();
                return image;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public static ImageIcon loadIcon(String resourcePath) {
        Image image = loadImage(resourcePath);
        return (image != null) ? new ImageIcon(image) : null;
    }
    public static InputStream loadAudio(String resourcePath) {
        InputStream is = ResourceUtil.class.getResourceAsStream(resourcePath);
        return is;
    }
    public static boolean resourceExists(String resourcePath) {
        return ResourceUtil.class.getResourceAsStream(resourcePath) != null;
    }
}