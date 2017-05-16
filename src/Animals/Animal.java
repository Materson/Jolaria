/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import jolaria.Organism;
import Worlds.World;
import jolaria.Position;
/**
 *
 * @author Materson
 */
public class Animal extends Organism{

	Animal(int power, int activity, World world, int x, int y)
        {
            this.power = power;
            this.activity = activity;
            this.world = world;
            this.x = x;
            this.y = y;
        }
        
        public void action()
        {
            int move_dx=0, move_dy=0;
            randMove(move_dx, move_dy, 1);
            action(move_dx, move_dy);
        }

	public void action(int move_dx, int move_dy)
        {
            if (world.checkPlace(x + move_dx, y + move_dy) != '!')
            {
                    if (world.checkPlace(x + move_dx, y + move_dy) == ' ')
                    {
                            world.moveOrganism(this, x + move_dx, y + move_dy);
                            world.addComment(String.valueOf(image), "move");
                    }
                    else
                    {
                            world.collision(this, x + move_dx, y + move_dy);
                    }
            }
        }

	public void collision(Organism attacker)
        {
            if (attacker.getImage() == image)
            {
                    //copulate
                    Position pos = new Position();
                    pos.x = x;
                    pos.y = y;
                    if (world.findFreeSpace(pos, 1))
                    {
                            world.addOrganism(image, pos.x, pos.y);
                            world.addComment(String.valueOf(image), "multiplied");
                    }
                    else
                    {
                            world.addComment(String.valueOf(image), "don't find space for multiplied");
                    }
            }
            else
            {
                    //attack
                    if (attacker.getPower() < power)
                    {
                            world.addComment(String.valueOf(image), "ate", String.valueOf(attacker.getImage()));
                            world.delOrganism(attacker);
                    }
                    else
                    {
                            int a = x, b = y;
                            world.moveOrganism(attacker, a, b);
                            world.addComment(String.valueOf(attacker.getImage()), "ate", String.valueOf(image));
                            world.delOrganism(this);
                    }
            }
        }
}
