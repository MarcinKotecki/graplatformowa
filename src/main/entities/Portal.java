package main.entities;

import main.GameEngine;
import main.resources.Levels;
import main.resources.ResourceLoader;

public class Portal extends Entity{

    private int id;
    private int nextLevel;

    public Portal(int id, int x, int y, int nextLevel, String path) {
        this.id = id;
        setX((double)x);
        setY((double)y);
        this.nextLevel = nextLevel;
        setTexture(ResourceLoader.loadImage(path));
    }

    public Portal(int id) {
        this.id = Portals.getFromList(id).getId();
        this.nextLevel = Portals.getFromList(id).getNextLevel();
        setX(Portals.getFromList(id).getX());
        setY(Portals.getFromList(id).getY());
        setTexture(Portals.getFromList(id).getTexture());
    }

    private int getNextLevel() {
        return nextLevel;
    }

    public void update() {
        boolean temp = true;
        if ((getY() >= GameEngine.player.getY() + GameEngine.player.getTexture().getHeight() - 1)
                || (getY() + getTexture().getHeight() - 1 <= GameEngine.player.getY()))
            temp = false;
        else if ((getX() + getTexture().getWidth() - 1 <= GameEngine.player.getX())
                || (getX() >= GameEngine.player.getX() + GameEngine.player.getTexture().getWidth() - 1))
            temp = false;
        if (temp) {
            Portals.remove(this);
            Levels.changeLevel(nextLevel);
        }
    }

    public int getId(){
        return id;
    }

}
