package main.entities;


import org.junit.Assert;
import org.junit.Test;
public class PortalsTest {

    @Test
    public void test_poratls_Init() {

        Portals portal = new Portals();
        Portals.init();

        Assert.assertEquals(Portals.getFromList(0).getId(), 0);
        Assert.assertEquals(Portals.getFromList(0).getX(), 560);
        Assert.assertEquals(Portals.getFromList(0).isAnimated(), 1);
        Assert.assertNull(Portals.getFromList(2));

    }
}
