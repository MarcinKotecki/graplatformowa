package main.entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Projectiles {

    private static ArrayList<Projectile> projectilesList;
    public static ArrayList<Projectile> projectiles;
    private static ArrayList<Projectile> projectilesToRemove;

    public static void init() {
        projectilesList = new ArrayList<>();
        projectiles = new ArrayList<>();
        projectilesToRemove = new ArrayList<>();
        projectilesList.add(new Projectile(0, 0, 50, 2.5, "/textures/fireball.png", true));
        projectilesList.add(new Projectile(1, 1, 50, 2.5, "/textures/fireball-blue.png",true));
        projectilesList.add(new Projectile(2, 1, 1, 2, "/textures/spikes-p.png",false));
    }

    public static void update() {
        for (Projectile projectile : projectiles)
            projectile.update();
        projectiles.removeAll(projectilesToRemove);
    }

    public static void draw(BufferedImage frameImg) {
        for (Projectile projectile : projectiles)
            projectile.draw(frameImg);
    }

    public static void removeProjectile(Projectile p) {
        for (Projectile projectile : projectiles)
            if (projectile.hashCode() == p.hashCode())
                projectilesToRemove.add(p);
    }

    public static Projectile getProjectileFromList(int id) {
        for (Projectile projectile : projectilesList)
            if (projectile.getId() == id)
                return projectile;
        return null;
    }

    static void newProjectile(int id, double range, int dir, double x, double y) {
        projectiles.add(new Projectile(id, range));
        projectiles.get(projectiles.size() - 1).setX(x - (projectilesList.get(id).getTexture().getWidth() >> 1));
        projectiles.get(projectiles.size() - 1).setY(y - (projectilesList.get(id).getTexture().getHeight() >> 1));
        projectiles.get(projectiles.size() - 1).setVx(projectiles.get(projectiles.size() - 1).getVx() * dir);
    }
}
