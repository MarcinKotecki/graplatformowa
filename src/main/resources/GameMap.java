package main.resources;

import main.GameEngine;

import java.awt.*;
import java.util.Scanner;

public class GameMap {

    private String name;
    private int id;
    private int width;
    private int height;
    private String path;
    private Tile[][] tiles;
    private int offsetX;
    private int maxoffsetX;
    private int playerX, playerY;

    GameMap(String name, int id, String path) {
        this.name = name;
        this.id = id;
        this.path = path;
        loadMap();
    }

    private void loadMap() {
        Scanner in = ResourceLoader.loadTxt(path);
        this.width = in.nextInt();
        this.height = in.nextInt();
        maxoffsetX = this.width * 16 - GameEngine.width;
        tiles = new Tile[width][height];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                tiles[x][y] = Tiles.getTile(in.nextInt());
        playerX = in.nextInt();
        playerY = in.nextInt();
    }

    public void update() {

    }

    public void draw(Graphics g) {
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                g.drawImage(tiles[x][y].getTexture(), ((x * 16) - offsetX) * GameEngine.scale, ((y * 16) * GameEngine.scale), 16 * GameEngine.scale, 16 * GameEngine.scale, null);
    }

    public Tile getTileByXY(double x, double y) {
        int xx = (int) x;
        int yy = (int) y;
        xx /= 16;
        yy /= 16;
        if (xx >= width)
            xx = width - 1;
        if (yy >= height)
            yy = height - 1;
        if (xx < 0)
            xx = 0;
        if (yy < 0)
            yy = 0;
        return tiles[xx][yy];
    }

    int getId() {
        return id;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffSetX(int i) {
        offsetX = i;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getWidth() {
        return width * 16;
    }
}