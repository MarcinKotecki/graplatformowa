package main.display;

import main.GameEngine;

import java.awt.*;

public class Hud {

    public static Font HUDfont = new Font("Consolas", Font.BOLD, 8 * GameEngine.scale);
    private static String s;
    private static int[] x, y, w, h;
    private static Color[] c;
    private static FontMetrics fm;

    public static void init(main.graphics.Display display) {
        fm = display.getCanvas().getFontMetrics(HUDfont);
        x = new int[10];
        y = new int[10];
        w = new int[10];
        h = new int[10];
        c = new Color[10];

        x[0] = 3 * GameEngine.scale;
        y[0] = 3 * GameEngine.scale;
        w[0] = 60 * GameEngine.scale;
        h[0] = 10 * GameEngine.scale;
        x[1] = 4 * GameEngine.scale;
        y[1] = 4 * GameEngine.scale;
        w[1] = 58 * GameEngine.scale;
        h[1] = 8 * GameEngine.scale;
        x[2] = 3 * GameEngine.scale + (60 * GameEngine.scale - fm.stringWidth(GameEngine.player.getMaxHp() + "/" + GameEngine.player.getMaxHp())) / 2;
        y[2] = 3 * GameEngine.scale + ((11 * GameEngine.scale - fm.getHeight()) / 2) + fm.getAscent();
        x[3] = 3 * GameEngine.scale;
        y[3] = 16 * GameEngine.scale;
        w[3] = 60 * GameEngine.scale;
        h[3] = 10 * GameEngine.scale;
        x[4] = 4 * GameEngine.scale;
        y[4] = 17 * GameEngine.scale;
        w[4] = 58 * GameEngine.scale;
        h[4] = 8 * GameEngine.scale;
        x[5] = 3 * GameEngine.scale + (60 * GameEngine.scale - fm.stringWidth(GameEngine.player.getMaxMana() + "/" + GameEngine.player.getMaxMana())) / 2;
        y[5] = 16 * GameEngine.scale + ((11 * GameEngine.scale - fm.getHeight()) / 2) + fm.getAscent();

        c[0] = new Color(255, 255, 255);
        c[1] = new Color(255, 0, 0);
        c[2] = new Color(0, 0, 0);
        c[3] = new Color(0, 0, 255);
    }

    public static void drawHUD(Graphics g) {
        g.setFont(HUDfont);

        g.setColor(c[0]);
        g.fillRect(x[0], y[0], w[0], h[0]);
        g.setColor(c[1]);
        g.fillRect(x[1], y[1], w[1] * GameEngine.player.getHp() / GameEngine.player.getMaxHp(), h[1]);
        s = GameEngine.player.getHp() + "/" + GameEngine.player.getMaxHp();
        g.setColor(c[2]);
        g.drawString(s, x[2], y[2]);

        g.setColor(c[0]);
        g.fillRect(x[3], y[3], w[3], h[3]);
        g.setColor(c[3]);
        g.fillRect(x[4], y[4], w[4] * (int) GameEngine.player.getMana() / GameEngine.player.getMaxMana(), h[4]);
        g.setColor(c[2]);
        s = (int) GameEngine.player.getMana() + "/" + GameEngine.player.getMaxMana();
        g.setColor(c[2]);
        g.drawString(s, x[5], y[5]);
    }

}
