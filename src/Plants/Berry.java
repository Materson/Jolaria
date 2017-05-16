/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plants;
import Worlds.World;
import jolaria.Organism;
/**
 *
 * @author Materson
 */
public class Berry extends Plant{
    public Berry(int power, World world, int x, int y)
    {
	super(power, world, x, y);
            image = 'b';
    }

    public void collision(Organism attacker)
    {
            world.addComment(String.valueOf(image), "poisoned", String.valueOf(attacker.getImage()));
            world.delOrganism(attacker);
    }
}
