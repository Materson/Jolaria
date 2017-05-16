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

public class Sheep extends JPanel {
	public Sheep() {
		setPreferredSize(new Dimension(400, 400));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// prostokat
		Rectangle2D rectangle = new Rectangle2D.Double(10, 10, 380, 380);
		// kolo
		Ellipse2D circle = new Ellipse2D.Double(10, 10, 380, 380);

		g2d.draw(rectangle);
		g2d.draw(circle);
                g.drawString("owca",1,10);
	}
}