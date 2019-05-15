package main.entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Portals {

    private static ArrayList<Portal> portalsList;
    public static ArrayList<Portal> portals;
    private static ArrayList<Portal> portalsToRemove;

    public static void init() {
        portalsList = new ArrayList<>();
        portals = new ArrayList<>();
        portalsToRemove = new ArrayList<>();
        portalsList.add(new Portal(0, 560, 100, 1, "/textures/portal.png", true));
    }

    public static void update() {
        for (Portal portal : portals)
            portal.update();
        portals.removeAll(portalsToRemove);
    }

    public static void draw(BufferedImage frameImg) {
        for (Portal portal : portals)
            portal.draw(frameImg);
    }

    public static void remove(Portal p) {
        for (Portal portal : portals)
            if (portal.hashCode() == p.hashCode())
                portalsToRemove.add(p);
    }

    public static Portal getFromList(int id) {
        for (Portal portal : portalsList)
            if (portal.getId() == id)
                return portal;
        return null;
    }

    public static void spawn(int id) {
        portals.add(new Portal(id));
    }

}
