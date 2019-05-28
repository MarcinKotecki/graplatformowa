package main.entities;


import org.junit.Assert;
import org.junit.Test;
public class PortalsTest {

    @Test
    public void test_poratls_Init() {

        Portals portal = new Portals();
        portal.init();

        Assert.assertEquals(Portals.portal(0).getId(), 0);
        Assert.assertEquals(Portals.getFromList(id).getX(), 560);
        Assert.assertEquals(Portals.getFromList(id).isAnimated(), 1);
        assertNull(Portals.portal(2));

    }
