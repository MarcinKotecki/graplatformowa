package main.entities;

import java.awt.*;
import java.util.ArrayList;

public class Creatures {

    private static ArrayList<Creature> creaturesList;
    public static ArrayList<Creature> creatures;
    private static ArrayList<Creature> creaturesToRemove;

    public static void init() {
        creaturesList = new ArrayList<>();
        creatures = new ArrayList<>();
        creaturesToRemove = new ArrayList<>();
        creaturesList.add(new Creature(0, 100, 0.8, 250, 1, 120, "/textures/enemy1.png"));
        creaturesList.add(new Creature(1, 500, 0, 400, 1, 60, "/textures/boss1.png", 0));
    }

    public static void update() {
        for (Creature creature : creatures)
            creature.update();
        creatures.removeAll(creaturesToRemove);
    }

    public static void draw(Graphics g) {
        for (Creature creature : creatures)
            creature.draw(g);
    }

    public static void removeCreature(Creature c) {
        for (Creature creature : creatures)
            if (creature.hashCode() == c.hashCode())
                creaturesToRemove.add(c);
    }

    public static Creature getCreatureFromList(int id) {
        for (Creature creature : creaturesList)
            if (creature.getId() == id)
                return creature;
        return null;
    }

    static void newCreature(int t[]) {
        creatures.add(new Creature(t));
    }

    public static void spawn(ArrayList<int[]> creaturesId) {
        creatures.removeAll(creatures);
        for (int[] i : creaturesId) {
            newCreature(i);
        }
    }
}