package main;

import java.awt.*;

public class Main {

    private static final int WINDOW_WIDTH = 384;
    private static final int WINDOW_HEIGHT = 240;

    public static void main(String[] args) {

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        int scalew = (width - 20) / WINDOW_WIDTH;
        int scaleh = (height - 60) / WINDOW_HEIGHT;
        int scale = Math.min(scalew, scaleh);

        GameEngine game;
        if (args.length == 0) {
            game = new GameEngine(WINDOW_WIDTH, WINDOW_HEIGHT, scale);
        } else if (args.length == 1) {
            game = new GameEngine(WINDOW_WIDTH, WINDOW_HEIGHT, Integer.parseInt(args[0]));
        } else {
            game = new GameEngine(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
        game.start();

    }

}