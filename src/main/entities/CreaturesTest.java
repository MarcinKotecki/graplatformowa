package main.entities;


import org.junit.Assert;
import org.junit.Test;

public class CreaturesTest {

    @Test
    public void testInit() {

        Creatures c = new Creatures();
        c.init();

        Assert.assertEquals(Creatures.getCreatureFromList(0).getHp(), 100);
        Assert.assertEquals(Creatures.getCreatureFromList(1).getProjectileId(), 1);
        Assert.assertEquals(Creatures.getCreatureFromList(2).getRange(), 12);
        Assert.assertNull(Creatures.getCreatureFromList(3));

    }

    @Test
    public void testNewCreature() {

        Creatures c = new Creatures();
        c.init();

        int[] t = {1, 2, 3, 4};

        Creatures.newCreature(t);

        Assert.assertEquals(Creatures.creatures.size(), 1);
        Assert.assertEquals(Creatures.creatures.get(0).getId(), 1);
        Assert.assertEquals((int) Creatures.creatures.get(0).getX1(), 2);
        Assert.assertEquals((int) Creatures.creatures.get(0).getX2(), 3);
        Assert.assertEquals((int) Creatures.creatures.get(0).getX(), 2);
        Assert.assertEquals((int) Creatures.creatures.get(0).getY(), 4);

    }


}
