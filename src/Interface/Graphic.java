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
        setLocation(200,10);
        setResizable(false);
//        setLayout(new FlowLayout());
//        setLayout(new BorderLayout());

        JPanel map = new Map(25,25);
        add(map, BorderLayout.LINE_START);
        
        JPanel menu = new RightBar();
        add(menu, BorderLayout.LINE_END);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
