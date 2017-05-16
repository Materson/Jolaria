/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import Worlds.World;
import jolaria.Organism;

/**
 *
 * @author Marek
 */
public class Turtle extends Animal{
    public Turtle(int power, int activity, World world, int x, int y)
    {
            super(power, activity, world, x, y);
            image = 't';
    }

    public void action(int dx, int dy)
    {
            dx = world.randInt(0,100);
            if (dx >= 75)
            {
                    super.action();
            }
            else
            {
                    world.addComment(String.valueOf(image), "resting");
            }
    }

    public void collision(Organism attacker)
    {
            if (attacker.getImage() == image)
            {
                    super.collision(attacker);
            }
            else if (attacker.getPower() >= 5)
            {
                    super.collision(attacker);
            }
            else
            {
                    world.addComment(String.valueOf(image), "blocked", String.valueOf(attacker.getImage()));
            }
    }

}
