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
import java.awt.geom.*;

import javax.swing.JPanel;

public class Map extends JPanel {
        private  static final int field = 20;
	public Map() {
		setPreferredSize(new Dimension(400, 400));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                
                for(int i=0; i<10; i++)
                {
                    for(int j=0; j<9; j++)
                    {
                        Rectangle2D rectangle = new Rectangle2D.Double(j*field, i*field, field, field);
                        g2d.draw(rectangle);
                    }
                }
	}
}