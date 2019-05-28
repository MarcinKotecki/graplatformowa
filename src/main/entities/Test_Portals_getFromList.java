package main.entities;


import org.junit.Assert;
import org.junit.Test;

public class PortalsTest {

    @Test
    Portals portal = new Portals();
    portal.init();    
    Assert.assertEquals(Portal.getFromList(0), portal);
    Assert.assertNull(Portal.getFromList(2));
    
    
    
    
    
    }


