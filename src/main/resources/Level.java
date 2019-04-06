package main.resources;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Level {

    private int id;
    private String name;
    private int mapId;
    private ArrayList<int[]> creatures;
    private String path;

    Level(int id, String path) {
        this.id = id;
        this.path = path;
        creatures = new ArrayList<>();
        load();
    }

    private void load() {
        Scanner in = ResourceLoader.loadTxt(path);
        try {
            String s = in.next();
            while (s != null) {
                if (s.equals("name"))
                    this.name = in.next();
                else if (s.equals("map"))
                    mapId = in.nextInt();
                else if (s.equals("creature")) {
                    int[] t = new int[4];
                    t[0] = in.nextInt();
                    t[1] = in.nextInt();
                    t[2] = in.nextInt();
                    t[3] = in.nextInt();
                    creatures.add(t);
                }
                s = in.next();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Finished loading level " + id);
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<int[]> getCreatures() {
        return creatures;
    }

    public int getMapId() {
        return mapId;
    }


}