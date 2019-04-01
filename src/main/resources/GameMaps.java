package main.resources;

import java.util.ArrayList;

public class GameMaps {

    private static ArrayList<GameMap> maps;

    public static void init() {
        maps = new ArrayList<>();
        maps.add(new GameMap("Map0", 0, "/maps/map0"));
        maps.add(new GameMap("Map1", 1, "/maps/map1"));
    }

    public static GameMap getMap(int id) {
        for (GameMap map : maps)
            if (map.getId() == id)
                return map;
        return null;
    }

}