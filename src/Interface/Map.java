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

import javax.swing.JPanel;

public class Map extends JPanel {
        private int width, height;
        private int map_width=700, map_height=700;
	public Map(int w, int h) {
		setPreferredSize(new Dimension(map_width, map_height));
                width = w;
                height = h;
                setBackground(Color.BLUE);
//                setLayout(new GridBagLayout());
                setLayout(new GridLayout(w,h));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                g.setColor(Color.BLACK);
                GridBagConstraints c = new GridBagConstraints();
                for(int i=0; i<height; i++)
                {
                    for(int j=0; j<width; j++)
                    {
                        JButton btn = new JButton(String.valueOf(j)+","+String.valueOf(i));
                        btn.setBackground(Color.red);
                        btn.setPreferredSize(new Dimension(map_width/width, map_height/height));
//                        btn.setLocation(j*map_height/width, i*map_width/height);
//                        c.gridx = j;
//                        c.gridy = i;
//                        c.anchor = GridBagConstraints.FIRST_LINE_START;
                        add(btn);
//                        c.fill = GridBagConstraints.BOTH;
//                        Rectangle2D rectangle = new Rectangle2D.Double(j*map_height/width, i*map_width/height, map_width/width, map_height/height);
//                        g2d.draw(rectangle);
                        
                    }
                }
	}
}