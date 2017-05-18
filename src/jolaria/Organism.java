/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jolaria;
import Worlds.World;

/**
 *
 * @author Materson
 */
public abstract class Organism {
    protected int power, activity, old = 1;
    protected int x, y;
    protected char image;
    protected World world;
    protected int skill = 0;

    public abstract void action(int move_x, int move_y);
    public void action()
    {
        int move_x=0, move_y=0;
        action(move_x, move_y);
    }
    public abstract void collision(Organism attacker);
    
 
    public void draw()
    {
            System.out.print(image);
    }

    public int getX()
    {
            return x;
    }

    public int getY()
    {
            return y;
    }

    public void setX(int x)
    {
            this.x = x;
    }

    public void setY(int y)
    {
            this.y = y;
    }

    public char getImage()
    {
            return image;
    }

    public void increaseOld()
    {
            old++;
    }

    public int getActivity()
    {
            return activity;
    }

    public int getOld()
    {
            return old;
    }

    public int getSkill()
    {
            return skill;
    }
    
    public int getPower()
    {
            return power;
    }

    public void setPower(int x)
    {
            power = x;
    }

    public void randMove(Position pos, int range)
    {
            int tmpx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
            int tmpy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

            boolean findPlace = false;
            int move_num = tmpx.length *range;
            int dx[] = new int[move_num];
            int dy[] = new int[move_num];
            for (int i = 0; i < range; i++)
            {
                    for (int j = 0; j < move_num / range; j++)
                    {
                            dx[(move_num / range)*i + j] = tmpx[j] * (i + 1);
                            dy[(move_num / range)*i + j] = tmpy[j] * (i + 1);
                    }
            }

            int place;
            int move[] = new int[move_num];
            for (int i = 0; i < move_num; i++)
            {
                    move[i] = i;
            }

            while (move_num > 0 && !findPlace)
            {
                    place = world.randInt(0, move_num--);
                    if (world.checkPlace(x + dx[move[place]], y + dy[move[place]]) == '!')
                    {
                            move[place] = move[move_num];
                            continue;
                    }

                    findPlace = true;
                    place = move[place];
                    pos.x = dx[place];
                    pos.y = dy[place];
            }
    }
}
