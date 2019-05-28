package main.entities;

import org.junit.Test;

import static org.junit.Assert.*;

import main.entities.Player;

public class PlayerTest {

    @Test
    public void testReset() throws Exception {
        Player testPlayer = Player.reset(10, 10);

        Assert.assertEquals(Player.getX(), testPlayer.getX());
        Assert.assertEquals(Player.getY(), testPlayer.getY());
    }

    @Test
    public void testCheckDifficulty() throws Exception {
        Player testPlayer = Player.checkDifficulty(0);
        Assert.assertEquals(Player.getMaxHp(), testPlayer.getMaxHp());

        testPlayer = Player.checkDifficulty(1);
        Assert.assertEquals(Player.getMaxHp(), testPlayer.getMaxHp());

        testPlayer = Player.checkDifficulty(2);
        Assert.assertEquals(Player.getMaxHp(), testPlayer.getMaxHp());

        testPlayer = Player.checkDifficulty(3);
        Assert.assertEquals(Player.getMaxHp(), testPlayer.getMaxHp());
    }
}