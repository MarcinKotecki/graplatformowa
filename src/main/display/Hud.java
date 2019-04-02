package main.display;

import main.GameEngine;

import java.awt.*;

public class Hud {

	public static Font HUDfont = new Font("Consolas", Font.BOLD, 8 * GameEngine.scale);

	public static void drawHUD(Graphics g) {
		g.setColor(new Color(255, 255, 255));
		g.fillRect(8, 8, 64 * GameEngine.scale, 8 * GameEngine.scale);
		g.setColor(new Color(255, 0, 0));
		g.drawRect(8, 8, 64 * GameEngine.scale, 8 * GameEngine.scale);
		g.fillRect(8, 8, GameEngine.player.getHp() * 64 / GameEngine.player.getMaxHp() * GameEngine.scale
				, 8 * GameEngine.scale);
		g.setColor(new Color(0, 0, 0));
		g.setFont(HUDfont);
		g.drawString("HP " + GameEngine.player.getHp() + "/" + GameEngine.player.getMaxHp(), 11, 5 + 8 * GameEngine.scale);
	}

}
