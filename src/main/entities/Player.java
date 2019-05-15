package main.entities;

import main.GameEngine;
import main.resources.Levels;
import main.resources.ResourceLoader;

public class Player extends Entity {

    private double vx, vy, range;
    private int shootingCooldown = 20; //TICKS
    private int hp, maxHp, maxMana;
    private double mana;

    public Player(int d) {
        this.maxHp = getDifficultyReturnHp(d);
        this.maxMana = 200;
        this.mana = maxMana;
        this.hp = getDifficultyReturnHp(d);
        this.range = 250;
        setX(0);
        setY(0);
        setTexture(ResourceLoader.loadImage("/textures/mage.png"));
    }

    private int getDifficultyReturnHp(int difficulty) {
        int Hp;
        if (difficulty == 0)
            Hp = 800;
        else if (difficulty == 1)
            Hp = 400;
        else if (difficulty == 2)
            Hp = 200;
        else
            Hp = 1;
        return Hp;
    }

    public void reset(int x, int y) {
        hp = maxHp;
        vx = 0;
        vy = 0;
        setX((double) x);
        setY((double) y);
    }

    public void update() {
        //fall
        if (!checkMapCollision(2, vx, vy) && vy < 3)
            vy += 0.2;
        if (vy > 0 && checkMapCollision(2, vx, vy))
            vy = 0.2;

        //jump
        if (checkMapCollision(2, vx, 1)) {
            vy = 0;
            if (GameEngine.km.up)
                vy = -5;
        }
        if (checkMapCollision(0, vx, vy))
            vy = 0;

        //right
        if (GameEngine.km.right && vx < 1.6)
            vx += 0.2;
        if ((checkMapCollision(1, vx, vy) || (getX() + getTexture().getWidth() >= GameEngine.currentMap.getWidth())) && vx > 0)
            vx = 0;

        //left
        if (GameEngine.km.left && vx > -1.6)
            vx -= 0.2;
        if ((checkMapCollision(3, vx, vy) || (getX() <= 0)) && vx < 0)
            vx = 0;

        //stop
        if (!GameEngine.km.left && !GameEngine.km.right)
            vx = 0;

        //move
        setX(getX() + vx);
        setY(getY() + vy);

        //shooting
        if ((shootingCooldown <= 0) && (mana >= 25)) {
            if (GameEngine.km.shootRight) {
                shootingCooldown += 20;
                mana -= 25;
                Projectiles.newProjectile(0, range, 1, getX() + (getTexture().getWidth() >> 1), getY() + (getTexture().getHeight() >> 1));
            } else if (GameEngine.km.shootLeft) {
                shootingCooldown += 20;
                mana -= 25;
                Projectiles.newProjectile(0, range, -1, getX() + (getTexture().getWidth() >> 1), getY() + (getTexture().getHeight() >> 1));
            }
        }
        if (shootingCooldown > 0)
            shootingCooldown--;

        //isDead
        if (hp <= 0) {
            Levels.changeLevel(GameEngine.currentLevel.getId());
        }

        //manaRegen
        if (mana < maxMana)
            mana += 0.25;
    }

    public int getHp() {
        return hp;
    }

    void setHp(int hp) {
        this.hp = hp;
        System.out.println("Player's hp = " + hp);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public double getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }
}
