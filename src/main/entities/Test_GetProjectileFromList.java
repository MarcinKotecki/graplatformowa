package main.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectilesTest1 {

    @Test
    public void getProjectileFromList() {
        Projectiles projectile  = new Projectiles();
        Projectiles.init();

        Assert.assertEquals(Projectiles.getProjectileFromList(1), projectile);
        Assert.assertNull(Projectiles.getProjectileFromList(10));

    }
}
