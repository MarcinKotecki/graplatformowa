package main;

import java.awt.*;

public class Main {

    private static final int WINDOW_WIDTH = 384;
    private static final int WINDOW_HEIGHT = 240;

    //0-EASY, 1-MEDIUM, 2-HARD, 3-VERY HARD
    private static final int DIFFICULTY_LEVEL = 0;

    public static void main(String[] args) {

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        int scalew = (width - 40) / WINDOW_WIDTH;
        int scaleh = (height - 120) / WINDOW_HEIGHT;
        int scale = Math.min(scalew, scaleh);

        GameEngine game;
        if (args.length == 0) {
            game = new GameEngine(WINDOW_WIDTH, WINDOW_HEIGHT, scale, DIFFICULTY_LEVEL);
        } else if (args.length == 1) {
            game = new GameEngine(WINDOW_WIDTH, WINDOW_HEIGHT, Integer.parseInt(args[0]), DIFFICULTY_LEVEL);
        } else if (args.length == 2) {
            game = new GameEngine(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), DIFFICULTY_LEVEL);
        } else {
            game = new GameEngine(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        }

    }

}
