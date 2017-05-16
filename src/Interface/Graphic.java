/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
/**
 *
 * @author Materson
 */
public class Graphic extends JFrame {
    public Graphic()
    {
        super("Rysowanie");
        JPanel map = new Map();
        setSize(500, 500);
        setLocation(200,50);
        add(map);

//        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
