package main.entities;


import org.junit.Assert;
import org.junit.Test;

public class PortalsTest {

    @Test
    public void test_poratls_Init() {

        Portals portal = new Portals();
        Portals.init();

        Assert.assertEquals(Portals.getFromList(0), portal);
        Assert.assertNull(Portals.getFromList(2));


    }
    }



