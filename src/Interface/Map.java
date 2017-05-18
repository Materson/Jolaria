/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Materson
 */
import Animals.Animal;
import Animals.Human;
import Plants.Plant;
import Worlds.World;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class Map extends JPanel implements KeyListener{
        private World jolaria;
        private int width, height;
        private int map_width=700, map_height=700;
        private RightBar menu;
        JButton[][] buttons;
        
	public Map(int w, int h, RightBar menu) {
		setPreferredSize(new Dimension(map_width, map_height));
                width = w;
                height = h;
                this.menu = menu;
                setBackground(Color.BLUE);
                setLayout(new GridLayout(h,w));
                jolaria = new World(w, h, menu);
                createButtons();
	}

	protected void createButtons() {
                buttons = new JButton[width][height];
                for(int i=0; i<height; i++)
                {
                    for(int j=0; j<width; j++)
                    {
                        buttons[j][i] = new JButton(String.valueOf(jolaria.checkPlace(j, i)));
                        buttons[j][i].setBackground(Color.WHITE);
                        colorButton(j,i);
                        
                        add(buttons[j][i]);
                        
                    }
                }
	}
        
        public void nextTurn()
        {
            jolaria.nextTurn();
            refresh();
        }
        
        public void refresh()
        {
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                   buttons[j][i].setText(String.valueOf(jolaria.checkPlace(j, i)));
                   colorButton(j,i);
                   add(buttons[j][i]);
                }
             }
        }
        
        public void colorButton(int j, int i)
        {
            if(jolaria.getOrganism(j,i) instanceof Animal)
            {
                buttons[j][i].setBackground(Color.RED);

                if(jolaria.getOrganism(j,i) instanceof Human)
                {
                    buttons[j][i].setBackground(Color.GRAY);
                }
            }
            else if(jolaria.getOrganism(j,i) instanceof Plant)
            {
                buttons[j][i].setBackground(Color.GREEN);
            }
            else
            {
                buttons[j][i].setBackground(Color.WHITE);
            }
        }
        
        @Override
    public void keyPressed(KeyEvent evt) {
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
//        int keyCode = e.getKeyCode();
//        switch( keyCode ) { 
//            case KeyEvent.VK_UP:
//                if (skill > 0)
//                        fire(0, -1);
//                else
//                        super.action(0, -1);
//                break;
//            case KeyEvent.VK_DOWN:
//                if (skill > 0)
//                        fire(0, 1);
//                else
//                        super.action(0, 1);
//                break;
//            case KeyEvent.VK_LEFT:
//                if (skill > 0)
//                        fire(-1, 0);
//                else
//                        super.action(-1, 0);
//                break;
//            case KeyEvent.VK_RIGHT :
//                if (skill > 0)
//                        fire(1, 0);
//                else
//                        super.action(1, 0);
//                break;
//            case KeyEvent.VK_SPACE :
//                if (skill > 0)
//                        fire();
//                else if (skill == 0)
//                {
//                        world.addComment(String.valueOf(image), "actived fire");
//                        skill = 5;
//                        image = 'O';
//                        fire();
//                }
//                else if (skill < 0)
//                {
//                        world.addComment("Fire light up;", String.valueOf((-1)*skill - 1) + " to ignite");
//
//                }
//                break;
//            case KeyEvent.VK_ESCAPE :
//                world.endGame();
//                break;
         }
        @Override
        public void keyTyped(KeyEvent evt) {

        }
    }
 