/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plants;
import jolaria.Organism;
import Worlds.World;
/**
 *
 * @author Materson
 */
public class Guarana extends Plant{
    public Guarana(int power, World  world, int x, int y)
    {
           super(power,world,x,y);
           image = 'G';
    }

    public void collision(Organism attacker)
    {
            attacker.setPower(attacker.getPower() + 3);
            world.addComment(String.valueOf(attacker.getImage()), "ate", String.valueOf(image)+" strength +"+String.valueOf(3)+" actual: "+String.valueOf(attacker.getPower()));
            super.collision(attacker);
    }

}
