/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import Worlds.World;
import jolaria.Organism;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
/**
 *
 * @author Materson
 */
public class Human extends Animal implements KeyListener{
    public Human(int power, int activity, World world, int x, int y)
    {
            super(power, activity, world, x, y);
            image = 'H';
            JFrame h = new JFrame();
            h.addKeyListener(this);
    }
    
    @Override
    public void keyPressed(KeyEvent evt) {
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                if (skill > 0)
                        fire(0, -1);
                else
                        super.action(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                if (skill > 0)
                        fire(0, 1);
                else
                        super.action(0, 1);
                break;
            case KeyEvent.VK_LEFT:
                if (skill > 0)
                        fire(-1, 0);
                else
                        super.action(-1, 0);
                break;
            case KeyEvent.VK_RIGHT :
                if (skill > 0)
                        fire(1, 0);
                else
                        super.action(1, 0);
                break;
            case KeyEvent.VK_SPACE :
                if (skill > 0)
                        fire();
                else if (skill == 0)
                {
                        world.addComment(String.valueOf(image), "actived fire");
                        skill = 5;
                        image = 'O';
                        fire();
                }
                else if (skill < 0)
                {
                        world.addComment("Fire light up;", String.valueOf((-1)*skill - 1) + " to ignite");

                }
                break;
            case KeyEvent.VK_ESCAPE :
                world.endGame();
                break;
         }
    }
 
    @Override
    public void keyTyped(KeyEvent evt) {
 
    }

    protected void finalize()
    {
            world.humanDie();
    }

    public void action(int dx, int dy)
    {
            if (skill < 0) skill++;
    }

    public void collistion(Organism attacker)
    {
            if (skill > 0)
            {
                    world.delOrganism(attacker);
                    world.addComment("H", "burn", String.valueOf(attacker.getImage()));
            }
            else
            {
                    super.collision(attacker);
            }
    }

    public void fire(int move_x, int move_y)
    {
            if (move_x != 0 || move_y != 0)
            {
                    char place = world.checkPlace(x + move_x, y + move_y);
                    if(place != ' ' && place != '!')
                            world.delOrganism(null, x + move_x, y + move_y);
                    super.action(move_x, move_y);
            }
            fire();
    }
    
    public void fire()
    {
            world.addComment("H:", "BURN IT ALL!;", String.valueOf(skill-1)+" left");
            int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
            int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

            for (int i = 0; i < dx.length; i++)
            {
                    char place = world.checkPlace(x + dx[i], y + dy[i]);
                    if (place != ' ' && place != '!')
                    {
                            world.delOrganism(null, x + dx[i], y + dy[i]);
                    }
            }
            if (--skill == 0)
            {
                    skill = -5-1;
                    world.addComment("H:", "Flame went out;", String.valueOf((-1)*skill - 1) + " to ignite");
                    image = 'H';
            }
    }

}
