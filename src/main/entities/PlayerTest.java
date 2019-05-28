package main.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import main.entities.Player;

public class PlayerTest {

    @Test
    public void testReset() throws Exception {
        Player testPlayerReset = new Player(0);
        testPlayerReset.reset(1138, 327);

        Assert.assertEquals(1138, (int) testPlayerReset.getX());
        Assert.assertEquals(327, (int) testPlayerReset.getY());
    }

    @Test
    public void testCheckDifficulty() throws Exception {
        Player testPlayerMaxHp = new Player(0);
        Assert.assertEquals(800, testPlayerMaxHp.getMaxHp());

        testPlayerMaxHp = new Player(1);
        Assert.assertEquals(400, testPlayerMaxHp.getMaxHp());

        testPlayerMaxHp = new Player(2);
        Assert.assertEquals(200, testPlayerMaxHp.getMaxHp());

        testPlayerMaxHp = new Player(3);
        Assert.assertEquals(1, testPlayerMaxHp.getMaxHp());
    }
}