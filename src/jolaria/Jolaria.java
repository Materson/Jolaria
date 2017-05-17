/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jolaria;
import Interface.Graphic;
import Worlds.World;
import java.util.Scanner;
import java.awt.EventQueue;
/**
 *
 * @author Materson
 */
public class Jolaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Graphic();
            }
        });
        
        
//        jolaria.nextTurn();
//        jolaria.drawWorld();
	int zn;
//        while (jolaria.humanAlive() || (String)scan.next() == (String)" ")
//	{
//		
//			jolaria.nextTurn();
//			jolaria.drawWorld();
//		
//		if (!jolaria.game()) break;
//	}
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
