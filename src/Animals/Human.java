/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import Worlds.World;
import jolaria.Organism;
import javax.swing.JFrame;
/**
 *
 * @author Materson
 */
public class Human extends Animal{
    public Human(int power, int activity, World world, int x, int y)
    {
            super(power, activity, world, x, y);
            image = 'H';
            JFrame h = new JFrame();
    }
    
   public void action(int dx, int dy)
{
	char move = ' ';
        if(dx == 0 && dy == -1) move = 'u';         //UP
        else if(dx == 1 && dy == 0) move = 'r';     //RIGHT
        else if(dx == 0 && dy == 1) move = 'd';     //DOWN
        else if(dx == -1 && dy == 0) move = 'l';    //LEFT
        else if(dx == -1 && dy == -1) move = 'e';   //ESC
        else if(dx == 1 && dy == 1) move = 's';     //SPACE
       
        switch (move)
        {
        case 'u':
                if (skill > 0)
                        fire(0, -1);
                else
                        super.action(0, -1);
                break;
        case 'r':
                if (skill > 0)
                        fire(1, 0);
                else
                        super.action(1, 0);
                break;
        case 'd':
                if (skill > 0)
                        fire(0, 1);
                else
                        super.action(0, 1);
                break;
        case 'l':
                if (skill > 0)
                        fire(-1, 0);
                else
                        super.action(-1, 0);
                break;
        case 'e':
                world.endGame();
                break;
        case 's':
                if (skill > 0)
                        fire();
                else if (skill == 0)
                {
                        world.addComment(String.valueOf(image), "actived fire");
                        skill = 5;
                        fire();
                }
                else if (skill < 0)
                {
                        world.addComment("Fire light up;", String.valueOf((-1)*skill - 1) + " to ignite");

                }
                break;
        }

	if (skill < 0) skill++;
}

    protected void finalize()
    {
            world.humanDie();
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
