/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import Worlds.World;

/**
 *
 * @author Marek
 */
public class Sheep extends Animal {
    public Sheep(int power, int activity, World world, int x, int y)
{
	super(power, activity, world, x, y);
	image = 's';
}
}
