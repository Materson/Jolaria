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
import java.io.IOException;

import javax.swing.JPanel;

public class Map extends JPanel{
        private World jolaria;
        private int width, height;
        private int map_width=700, map_height=700;
        private JPanel mapJPanel;
        private JButton[][] buttons;
        
	public Map(int w, int h, RightBar menu) {
                width = w;
                height = h;
                setBackground(Color.BLUE);
                
                jolaria = new World(w, h, menu);
                createButtons();
	}

	protected void createButtons() {
                mapJPanel = new JPanel();
                mapJPanel.setPreferredSize(new Dimension(map_width, map_height));
                mapJPanel.setLayout(new GridLayout(height,width));
                buttons = new JButton[width][height];
                for(int i=0; i<height; i++)
                {
                    for(int j=0; j<width; j++)
                    {
                        buttons[j][i] = new JButton(String.valueOf(jolaria.checkPlace(j, i)));
                        buttons[j][i].setBackground(Color.WHITE);
                        colorButton(j,i);
                        
                        mapJPanel.add(buttons[j][i], BorderLayout.CENTER);
                        
                    }
                }
                add(mapJPanel);
	}
        
        public void nextTurn(int dx, int dy)
        {
            jolaria.nextTurn(dx, dy);
            refresh();
        }
        
        public void refresh()
        {
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                   buttons[j][i].setText(String.valueOf(jolaria.checkPlace(j, i)));
                   colorButton(j,i);
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
        
        public void save()
        {
            jolaria.saveFile();
        }
        
        public void load()
        {
            try
            {
                jolaria.loadFile();
                height = jolaria.getHeight();
                width = jolaria.getWidth();
                remove(mapJPanel);
                createButtons();
                repaint();
                
            }
            catch(IOException e)
            {
                
            }
        }
        
        public int getMapWidth()
        {
            return width;
        }
        
        public int getMapHeight()
        {
            return height;
        }
    }
 