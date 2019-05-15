package main.entities;

import main.GameEngine;
import main.resources.Levels;
import main.resources.ResourceLoader;

public class Portal extends Entity{

    private int id;
    private int nextLevel;

    public Portal(int id, int x, int y, int nextLevel, String path,boolean animated) {
        this.id = id;
        setX((double)x);
        setY((double)y);
        this.nextLevel = nextLevel;
        setAnimated(animated);
        setTexture(ResourceLoader.loadImage(path));
        if (animated) {
            boolean loop = true;
            int i = 1;
            String fileName = path.substring(0, path.lastIndexOf('.'));
            try {
                while (loop) {
                    String fileName2 = fileName + i + ".png";
                    addAnimationFrame(ResourceLoader.loadImage(fileName2));
                    i++;
                }
            } catch (IllegalArgumentException e) {
                loop = false;
            }
        }
    }

    public Portal(int id) {
        this.id = Portals.getFromList(id).getId();
        this.nextLevel = Portals.getFromList(id).getNextLevel();
        setX(Portals.getFromList(id).getX());
        setY(Portals.getFromList(id).getY());
        setTexture(Portals.getFromList(id).getTexture());
        setAnimated(Portals.getFromList(id).isAnimated());
        if (isAnimated())
            setAnimationFrames(Portals.getFromList(id).getAnimationFrames());
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
