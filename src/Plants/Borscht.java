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
public class Borscht extends Plant{
    public Borscht(int power, World world, int x, int y)
    {
            super(power, world, x, y);
            image = 'X';
    }

    public void action(int a, int b)
    {
            int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
            int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

            for (int i = 0; i < dx.length; i++)
            {
                    char place = world.checkPlace(x + dx[i], y + dy[i]);
                    if (place != ' ' && place != '!' && world.checkOrganismActivity(x + dx[i], y + dy[i]) > 0)
                    {
                            world.addComment(String.valueOf(image), "poisoned", String.valueOf(place));
                            world.delOrganism(null, x + dx[i], y + dy[i]);
                    }
            }
    }

    public void collision(Organism attacker)
    {
            world.addComment(String.valueOf(image), "poisoned", String.valueOf(attacker.getImage()));
            world.delOrganism(attacker);
    }
}
