/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import Worlds.World;
import jolaria.Organism;
import jolaria.Position;
/**
 *
 * @author Marek
 */
public class Antelope extends Animal {

public Antelope(int power, int activity, World world, int x, int y)
{
	super(power, activity, world, x, y);
	image = 'a';
}

public void action(int dx, int dy)
{
	randMove(dx, dy, 2);
	super.action(dx, dy);
}

public void action()
{
        int dx=0, dy=0;
	action(dx,dy);
}

public void collision(Organism attacker)
{
	if (attacker.getImage() != image)
            {
                    if (world.randInt(0, 100) <= 50)
                    {
                            Position pos = new Position();
                            pos.x = x;
                            pos.y = y;
                            if (world.findFreeSpace(pos, 2))
                            {
                                    int a = x, b = y;
                                    super.action(pos.x - x, pos.y - y);
                                    world.moveOrganism(attacker, a, b);
                                    world.addComment(String.valueOf(image), "run away from", String.valueOf(attacker.getImage()));
                            }
                            else
                            {
                                    super.collision(attacker);
                            }
                    }
                    else
                    {
                            super.collision(attacker);
                    }
            }
            else
            {
                    super.collision(attacker);
            }
        }

}
