package main.entities;

import main.Drawing;
import main.GameEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    private BufferedImage texture;
    private boolean glow = false;
    private double x, y;

    public void draw(BufferedImage frameImg) {
        Drawing.drawImage(texture, frameImg, (int) x - GameEngine.currentMap.getOffsetX(), (int) y);
    }

    // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo
    boolean checkMapCollision(int dir, double vx, double vy) {
        switch (dir) {
            case 0:
                if (GameEngine.currentMap.getTileByXY(Math.floor(getX())
                        , Math.floor(getY()) + vy).isSolid()
                        || GameEngine.currentMap.getTileByXY(Math.floor(getX()) - 1 + getTexture().getWidth()
                        , getY() + vy).isSolid()) {
                    return true;
                }
                break;
            case 1:
                if (GameEngine.currentMap.getTileByXY(Math.floor(getX()) + vx + getTexture().getWidth()
                        , getY()).isSolid()
                        || GameEngine.currentMap.getTileByXY(Math.floor(getX()) + vx + getTexture().getWidth()
                        , Math.floor(getY()) - 2 + getTexture().getHeight()).isSolid()) {
                    return true;
                }
                break;
            case 2:
                if (GameEngine.currentMap.getTileByXY(Math.floor(getX())
                        , (getY() + vy) + getTexture().getHeight() - 1).isSolid()
                        || GameEngine.currentMap.getTileByXY(Math.floor(getX()) - 1 + getTexture().getWidth()
                        , (getY() + vy) + getTexture().getHeight() - 1).isSolid()) {
                    return true;
                }
                break;
            case 3:
                if (GameEngine.currentMap.getTileByXY(Math.floor(getX()) + vx
                        , getY()).isSolid()
                        || GameEngine.currentMap.getTileByXY(Math.floor(getX()) + vx
                        , Math.floor(getY()) - 2 + getTexture().getHeight()).isSolid()) {
                    return true;
                }
                break;
        }
        return false;
    }

    void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    public void setGlow(boolean glow) {
        this.glow = glow;
    }

    public boolean getGlow() {
        return glow;
    }

}

