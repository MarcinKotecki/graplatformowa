package main.entities;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ProjectilesTest {

	
	
	
	@Test
	public void testInit() {
		
		Projectiles p = new Projectiles();
		p.init();
		
		Assert.assertEquals(Projectiles.getProjectileFromList(0).getId(), 0);
        Assert.assertEquals(Projectiles.getProjectileFromList(1).getDamage(), 50);
        Assert.assertTrue(Projectiles.getProjectileFromList(0).getRange()==0.0);
        Assert.assertTrue(Projectiles.getProjectileFromList(3)==(null));

	}
	
	
	
	@Test
	public void testNewProjectiles() {

		Projectiles p = new Projectiles();
		p.init();

	    p.newProjectile(0, 10, 5, 4, 8);

        Assert.assertEquals(Projectiles.projectiles.size(), 1);
		Assert.assertEquals(Projectiles.projectiles.get(0).getId(), 0);
		Assert.assertTrue(Projectiles.projectiles.get(0).getRange()==10);
        Assert.assertEquals((int) Projectiles.projectiles.get(0).getX(), 4-(Projectiles.projectiles.get(0).getTexture().getWidth() >> 1));
        Assert.assertEquals((int) Projectiles.projectiles.get(0).getY(), 8-(Projectiles.projectiles.get(0).getTexture().getHeight() >> 1));


	    }

}
