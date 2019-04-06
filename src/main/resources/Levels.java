package main.resources;

import main.GameEngine;
import main.entities.*;

import java.util.ArrayList;

public class Levels {

    private static ArrayList<Level> levels;

    public static void init() {
        levels = new ArrayList<>();
        levels.add(new Level(0, "/levels/level0"));
        levels.add(new Level(1, "/levels/level1"));
    }

    private static Level getLevel(int id) {
        for (Level level : levels) {
            if (level.getId() == id) {
                return level;
            }
        }
        return null;
    }

    public static void changeLevel(int id) {
        GameEngine.currentLevel = Levels.getLevel(id);
        for (Creature creature : Creatures.creatures)
            Creatures.removeCreature(creature);
        for (Projectile projectile : Projectiles.projectiles)
            Projectiles.removeProjectile(projectile);
        assert GameEngine.currentLevel != null;
        GameEngine.currentMap = GameMaps.getMap(GameEngine.currentLevel.getMapId());
        assert GameEngine.currentMap != null;
        GameEngine.currentMap.setOffSetX(0);
        Creatures.spawn(GameEngine.currentLevel.getCreatures());
        GameEngine.player.reset(GameEngine.currentMap.getPlayerX(), GameEngine.currentMap.getPlayerY());
    }

}