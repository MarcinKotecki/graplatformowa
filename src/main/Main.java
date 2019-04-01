package main;

public class Main {

    public static void main(String[] args) {

        GameEngine game;
        if (args.length == 0) {
            game = new GameEngine(384, 240, 2);
        } else if (args.length == 1) {
            game = new GameEngine(384, 240, Integer.parseInt(args[0]));
        } else {
            game = new GameEngine(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
        game.start();

    }

}