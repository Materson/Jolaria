/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plants;
import Worlds.World;
/**
 *
 * @author Materson
 */
public class Milk extends Plant{
    public Milk(int power, World world, int x, int y)
{
	super(power, world, x, y);
	image = 'm';
}

    @Override
    public void action(int dx, int dy)
{
	for (int i = 0; i < 3; i++)
	{
		super.action(dx, dy);
	}
}

}
