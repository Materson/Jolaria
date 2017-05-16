/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import Worlds.World;
/**
 *
 * @author Marek
 */
public class Fox extends Animal{

    public Fox(int power, int activity, World world, int x, int y)
    {
        super(power, activity, world, x, y);
            image = 'f';
    }

    public void action(int a, int b)
    {
            int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
            int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
            boolean findPlace = false;
            int move_num = dx.length;
            int move[] = new int[move_num];
            int rand_int;
            char place;
            for (int i = 0; i < move_num; i++)
            {
                    move[i] = i;
            }

            while (move_num >= 0 && !findPlace)
            {
                    rand_int = world.randInt(0, move_num--);
                    place = world.checkPlace(x + dx[move[rand_int]], y + dy[move[rand_int]]);
                    if (place == '!')
                    {
                            move[rand_int] = move[move_num];
                            continue;
                    }

                    if (place != ' ')
                    {
                            if (world.checkOrganismPower(x + dx[move[rand_int]], y + dy[move[rand_int]]) > power)
                            {
                                    move[rand_int] = move[move_num];
                                    world.addComment(String.valueOf(image), "hissed", String.valueOf(place));
                                    continue;
                            }
                    }

                    findPlace = true;
                    super.action(dx[move[rand_int]], dy[move[rand_int]]);
            }
    }

}
