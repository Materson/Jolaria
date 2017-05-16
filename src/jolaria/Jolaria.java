/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jolaria;
import Worlds.World;

/**
 *
 * @author Materson
 */
public class Jolaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        World jolaria= new World(5, 5);
        jolaria.nextTurn();
        jolaria.drawWorld();
	int zn;
//	while (jolaria.humanAlive() || ((zn=getch()) != ESC))
//	{
//		if (jolaria.humanAlive() || zn == ' ')
//		{
//			jolaria.nextTurn();
//			jolaria.drawWorld();
//		}
//		if (!jolaria.game()) break;
//	}
    }
    
}
