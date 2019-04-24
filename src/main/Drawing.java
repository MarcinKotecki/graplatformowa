package main;

import java.awt.image.BufferedImage;

public class Drawing {

    public static void drawImage(BufferedImage smaller, BufferedImage larger, int x, int y) {
        larger.getGraphics().drawImage(smaller, x, y, null);
    }

}
