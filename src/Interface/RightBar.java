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

import javax.swing.*;

public class RightBar extends JPanel {
        private int height = 700, width = 300;
	public RightBar() {
		setPreferredSize(new Dimension(width, height));
                setLayout(new FlowLayout());
                setBackground(Color.gray);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
                g.setColor(Color.RED);
		Graphics2D g2d = (Graphics2D) g;
                Rectangle2D rectangle = new Rectangle2D.Double(0, 0, width, height);
                g2d.draw(rectangle);
//                JTextField widthField = new JTextField("Szerokosc");
                    
	}
}