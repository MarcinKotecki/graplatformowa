package main.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCreaturesGetFromList {

    @Test
    public void getCreatureFromList() {

        Creatures creature  = new Creatures();
        Creatures.init();

        Assert.assertEquals(Creatures.getCreatureFromList(0), creature);
        Assert.assertNull(Creatures.getCreatureFromList(10));

    }
}
