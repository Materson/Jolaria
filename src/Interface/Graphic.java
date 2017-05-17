/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Materson
 */
public class Graphic extends JFrame {
    public Graphic()
    {
        super("Jolaria - Mateusz Szymanowski nr:165319");
        setSize(1000, 730);
        setLocation(200,30);
        setResizable(false);
//        setLayout(new FlowLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.BOTH;

        JPanel map = new Map(9,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 7;
        c.ipady = 700;
        add(map,c);
        
        JPanel menu = new RightBar();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 7;
        c.gridy = 0;
        c.weightx = 3;
        c.anchor = GridBagConstraints.LINE_END;
        
        add(menu,c);

//        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
