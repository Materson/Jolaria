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
public class Grass extends Plant{
    public Grass(int power, World world, int x, int y)
    {
            super(power, world, x, y);
            this.image = 'g';
    }
}
