/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plants;
import Worlds.World;
import jolaria.Organism;
import jolaria.Position;
/**
 *
 * @author Materson
 */
public class Plant extends Organism{

    public Plant(int power, World world, int x, int y)
    {
            this.power = power;
            this.world = world;
            this.x = x;
            this.y = y;
            activity = 0;
    }

    public void action(int move_dx, int move_dy)
    {
            if (world.randInt(0, 100) <= 2*10)
            {
                Position pos = new Position();
                    pos.x = x;
                    pos.y = y;
                    if (world.findFreeSpace(pos, 1))
                    {
                            world.addOrganism(image, pos.x, pos.y);
                            world.addComment(String.valueOf(image), "spread");
                    }
            }
    }
    
    public void action()
    {
        int move_dx=0, move_dy=0;
        action(move_dx, move_dy);
    }

    public void collision(Organism attacker)
    {
            int a = x, b = y;
            world.moveOrganism(attacker, a, b);
            world.addComment(String.valueOf(attacker.getImage()), "ate", String.valueOf(image));
            world.delOrganism(this);
    }
}
