package main.entities;


import org.junit.Assert;
import org.junit.Test;

public class PortalsTest {

    @Test
    Portals portal = new Portals();
    portals.init();    
    Assert.assertEquals(Portals.getFromList(0), portal);
    Assert.assertNull(Portals.getFromList(2));
    
    
    
    
    
    }


