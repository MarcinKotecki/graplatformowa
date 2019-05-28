package main.entities;

import main.GameEngine;
import main.resources.ResourceLoader;

import java.util.Random;

public class Creature extends Entity {

    private int id;
    private double x1, x2, vx, vy;
    private int hp;
    private int projectileId;
    private int shootingCooldown;
    private int shootingTimer;
    private int range;
    private int portalId;

    Creature(int id, int hp, double vx, int range, int projectileId, int shootingCooldown, String path) {
        this.id = id;
        this.vx = vx;
        this.hp = hp;
        this.range = range;
        this.projectileId = projectileId;
        this.shootingCooldown = Math.max(1, (int) (shootingCooldown * (1 - 0.13 * GameEngine.difficulty)));
        setX(x1);
        setTexture(ResourceLoader.loadImage(path));
        this.portalId = -111;
    }

    Creature(int id, int hp, double vx, int range, int projectileId, int shootingCooldown, String path, int portalId) {
        this.id = id;
        this.vx = vx;
        this.hp = hp;
        this.range = range;
        this.projectileId = projectileId;
        this.shootingCooldown = Math.max(1, (int) (shootingCooldown * (1 - 0.13 * GameEngine.difficulty)));
        setX(x1);
        setTexture(ResourceLoader.loadImage(path));
        this.portalId = portalId;
    }

    Creature(int t[]) {
        this.id = t[0];
        this.x1 = t[1];
        this.x2 = t[2];
        this.vx = Creatures.getCreatureFromList(id).getVx();
        this.hp = Creatures.getCreatureFromList(id).getHp();
        this.range = Creatures.getCreatureFromList(id).getRange();
        this.projectileId = Creatures.getCreatureFromList(id).getProjectileId();
        this.shootingCooldown = Creatures.getCreatureFromList(id).getShootingCooldown();
        this.shootingTimer = shootingCooldown;
        this.portalId = Creatures.getCreatureFromList(id).getPortalId();
        setX(t[1]);
        setY(t[3]);
        setTexture(Creatures.getCreatureFromList(id).getTexture());
    }

    private int getPortalId() {
        return portalId;
    }

    void update() {
        if (!GameEngine.currentMap.getTileByXY(Math.floor(getX()), Math.floor(getY()) + getTexture().getHeight()).isSolid()
                && !GameEngine.currentMap.getTileByXY(Math.floor(getX()) - 1 + getTexture().getWidth()
                , Math.floor(getY()) + getTexture().getHeight()).isSolid()) {
            if (vy < 3)
                vy += 0.2;
        }
        if (GameEngine.currentMap.getTileByXY(Math.floor(getX()), Math.floor(getY()) + getTexture().getHeight()).isSolid()
                || GameEngine.currentMap.getTileByXY(Math.floor(getX()) - 1 + getTexture().getWidth()
                , Math.floor(getY()) + getTexture().getHeight()).isSolid()) {
            vy = 0;
        }
        if (getX() > x2) {
            vx = -Math.abs(vx);
        } else if (getX() < x1) {
            vx = Math.abs(vx);
        }
        setX(getX() + vx);
        setY(getY() + vy);
        if (shootingTimer <= 0 && Math.abs((getX() + getTexture().getWidth() / 2) - (GameEngine.player.getX() + GameEngine.player.getTexture().getWidth() / 2)) <= range) {
            shootingTimer += shootingCooldown;
            double yy = GameEngine.player.getY() + GameEngine.player.getTexture().getHeight() / 2 - Projectiles.getProjectileFromList(projectileId).getTexture().getHeight() / 2;
            if (yy > getY() + getTexture().getHeight() - 1 - (1 + Projectiles.getProjectileFromList(projectileId).getTexture().getHeight()) / 2)
                yy = getY() + getTexture().getHeight() - 1 - (1 + Projectiles.getProjectileFromList(projectileId).getTexture().getHeight()) / 2;
            else if (yy < getY())
                yy = getY();
            if (GameEngine.player.getX() < this.getX()) {
                Projectiles.newProjectile(projectileId, range, -1, getX() + (getTexture().getWidth() >> 1), yy);
            } else {
                Projectiles.newProjectile(projectileId, range, 1, getX() + (getTexture().getWidth() >> 1), yy);
            }
        }
        if (shootingTimer > 0)
            shootingTimer--;
        if (hp <= 0) {
            if (portalId >= 0)
                Portals.spawn(portalId);
            Creatures.removeCreature(this);
        }
    }

    int getId() {
        return id;
    }

    double getX1() {
        return x1;
    }

    double getX2() {
        return x2;
    }

    int getHp() {
        return hp;
    }

    void setHp(int hp) {
        this.hp = hp;
    }

    private double getVx() {
        return vx;
    }

    int getProjectileId() {
        return projectileId;
    }

    private int getShootingCooldown() {
        return shootingCooldown;
    }

    int getRange() {
        return range;
    }
}