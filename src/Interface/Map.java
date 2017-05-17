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
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class Map extends JPanel {
        private int width, height;
        private int map_width=700, map_height=700;
	public Map(int w, int h) {
		setPreferredSize(new Dimension(map_width, map_height));
                width = w;
                height = h;
                setBackground(Color.BLUE);
                setLayout(new GridLayout(h,w));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                g.setColor(Color.BLACK);
                for(int i=0; i<height; i++)
                {
                    for(int j=0; j<width; j++)
                    {
                        JButton btn = new JButton(String.valueOf(j)+","+String.valueOf(i));
                        btn.setBackground(Color.red);
                        add(btn);
                        
                    }
                }
	}
}