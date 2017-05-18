/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 *
 * @author Materson
 */
public class Move extends AbstractAction{
    private int dx,dy;
    Map map;
        Move(int dx, int dy, Map map) {

            this.dx = dx;
            this.dy = dy;
            this.map = map;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            map.nextTurn(dx, dy);
        }
}
