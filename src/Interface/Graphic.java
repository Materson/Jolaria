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
    public Map map;
    private RightBar menu;
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    private static final String SPACE = "SPACE";
    private static final String ESC = "ESC";
    public Graphic()
    {
        super("Jolaria - Mateusz Szymanowski nr:165319");
        setSize(1000, 730);
        setLocation(200,10);
        setResizable(false);
        
        menu = new RightBar(this);
        add(menu, BorderLayout.LINE_END);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public void createMap(int w, int h)
    {
        map = new Map(w,h, menu);
        add(map, BorderLayout.LINE_START);
        
        map.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), UP);
        map.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), DOWN);
        map.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), LEFT);
        map.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), RIGHT);
        map.getInputMap(IFW).put(KeyStroke.getKeyStroke("ESC"), ESC);
        map.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SPACE);
        
        map.getActionMap().put(UP, new Move(0,-1, map));
        map.getActionMap().put(DOWN, new Move(0,1, map));
        map.getActionMap().put(LEFT, new Move(-1,0, map));
        map.getActionMap().put(RIGHT, new Move(1,0, map));
        map.getActionMap().put(SPACE, new Move(1,1, map));
    }
}
