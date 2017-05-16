/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Worlds;
import java.util.Random;
import jolaria.Organism;
import Animals.*;
/**
 *
 * @author Materson
 */
public class World {
//#include"IncludeOrganisms.h"

    private final int height, width;
    private int orgNum = 0;
    private boolean human, play;
    private String[] comments = new String[10];
    private int comment_i;
    private Organism[][] map;
    private Organism[] order;
    private static final int COMMENTS_AMOUNT = 10;
    private static final int FILL_RATIO = 5;

    public World(int width, int height)
    {

            this.width = width;
            this.height = height;
            map = new Organism[width][height];
            comment_i = 0;
            human = false;
            fillWorld();
            drawWorld();
            order = new Organism[width*height];
            setOrder();
    }

    //~World()
    //{
    //	for (int i = 0; i < height; i++)
    //	{
    //		for (int j = 0; j < width; j++)
    //		{
    //			if(map[j][i] != null)
    //				delete(map[j][i]);
    //		}
    //		delete[](map[i]);
    //	}
    //	delete[](map);
    //	
    //	delete[](order);
    //}

    public int getHeight()
    {
            return height;
    }

    public int getWidth()
    {
            return width;
    }

    public void nextTurn()
    {
        int num = orgNum;
        for (int i = 0; i < num; i++)
        {
                if (order[i] != null)
                        order[i].increaseOld();
        }

        for (int i = 0; i < num; i++)
        {
                if(order[i] != null)
                        order[i].action();
        }
        setOrder();
    }

    public void drawWorld()
    {
    //	system("cls");
    //	cout << "Mateusz Szymanowski, nr:165319" << endl;
    //	for (int i = 0; i <= height * 2; i++)
    //	{
    //		for (int j = 0; j <= width * 2; j++)
    //		{
    //			if (i % 2 == 0 && j%2 == 0) cout << "+";
    //			else if (i % 2 == 0 && j % 2 == 1) cout << "-";
    //
    //			if (i % 2 == 1 && j % 2 == 0)cout << "|";
    //			if (i % 2 == 1 && j % 2 == 1)
    //			{
    //				if (map[j / 2][i / 2] == null)
    //					cout << " ";
    //				else
    //					map[j / 2][i / 2].draw();
    //			}
    //		}
    //		cout << endl;
    //	}
    //	printComments();
        System.out.println("Rysuj swiat");
    }


    public void moveOrganism(Organism org, int x, int y)
    {
            map[x][y] = org;
            map[org.getX()][org.getY()] = null;
            org.setX(x);
            org.setY(y);
    }

    public char checkPlace(int x, int y)
    {
            if (x >= width || y >= height
                    || x < 0 || y < 0)
                    return '!';
            if (map[x][y] == null) return ' ';
            return map[x][y].getImage();
    }

    //set x, y at free place and return 1, otherwise return 0
    public boolean findFreeSpace(int x, int y, int range)
    {
            int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
            int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

            for (int j = 1; j <= range; j++)
            {
                    for (int i = 0; i < dx.length; i++)
                    {
                            char place = checkPlace((x) + (dx[i] * j), (y) + (dy[i] * j));
                            if (place == '!' || place != ' ')
                                    continue;

                            x += (dx[i] * j);
                            y += (dy[i] * j);
                            return true;
                    }
            }
            return false;
    }

    public int randInt(int min, int max)
    {
            Random rand = new Random();
            return rand.nextInt(max)+min;
    }

    public void addOrganism(char image, int x, int y)
    {
            switch (image)
            {
            case 'w':
                    map[x][y] = new Wolf(9, 5, this, x, y);
                    break;
            case 's':
                    map[x][y] = new Sheep(4, 4, this, x, y);
                    break;
            case 'f':
                    map[x][y] = new Fox(3, 7, this, x, y);
                    break;
            case 't':
                    map[x][y] = new Turtle(2, 1, this, x, y);
                    break;
            case 'a':
                    map[x][y] = new Antelope(4, 4, this, x, y);
                    break;
            case 'H':
                    map[x][y] = new Human(5, 5, this, x, y);
                    break;
//            case 'g':
//                    map[x][y] = new Grass(0, this, x, y);
//                    break;
//            case 'm':
//                    map[x][y] = new Milk(0, this, x, y);
//                    break;
//            case 'G':
//                    map[x][y] = new Guarana(0, this, x, y);
//                    break;
//            case 'b':
//                    map[x][y] = new Berry(99, this, x, y);
//                    break;
//            case 'X':
//                    map[x][y] = new Borscht(10, this, x, y);
//                    break;
            default:
                    map[x][y] = null;
                    orgNum--;
                    break;
            }
            orgNum++;
    }

    public void fillWorld()
    {
            String organism = "HabXfgGmstw";
            int h_x = -1, h_y = -1;
            for (int i = 0; i < organism.length(); i++)
            {
                    if (organism.charAt(i) == 'H')
                    {
                            if (!human)
                            {
                                    h_x = randInt(0, width);
                                    h_y = randInt(0, height);
                                    addOrganism('H', h_x, h_y);
                                    addComment("H", "created","");
                                    human = true;
                            }
                            organism.replace("H", " ");
                    }
            }

            for (int i = 0; i < height; i++)
            {
                    for (int j = 0; j < width; j++)
                    {
                            if (i == h_y && j == h_x)
                                    continue;
                            if (randInt(1, 100) <= FILL_RATIO*10)
                            {
                                    int rand_org = randInt(1, 100) % organism.length();
                                    addOrganism(organism.charAt(rand_org), j, i);
                                    if (organism.charAt(rand_org) != ' ')
                                            addComment(String.valueOf(organism.charAt(rand_org)), "created", "");
                            }
                            else
                            {
                                    map[j][i] = null;
                            }
                    }
            }


    }
    
    public void delOrganism(Organism org)
    {
        if(map[org.getX()][org.getY()] == org)
                    map[org.getX()][org.getY()] = null;
        for (int i = 0; i < orgNum; i++)
        {
                if (order[i] == org)
                {
                        order[i] = null;
                        break;
                }
        }
        orgNum--;
    }

    public void delOrganism(Organism org, int x, int y)
    {
            if(org == null)
            {
                    org = map[x][y];
            }
            delOrganism(org);            
    }

    public void setOrder()
    {
            int k = 0;
            for (int i = 0; i < height; i++)
            {
                    for (int j = 0; j < width; j++)
                    {
                            order[k++] = map[j][i];
                    }
            }

            //qsort(order, height*width, sizeof(Organism*), sortOrder);
    }

    //public void sortOrder(void or1, void or2)
    {
//            Organism *org1 = *(Organism**) or1;
//            Organism *org2 = *(Organism**) or2;
//
//            if (org1 == null && org2 == null)
//                    return 0;
//            else if (org1 != null && org2 == null)
//                    return -1;
//            else if(org1 == null && org2 != null)
//                    return 1;
//
//            if (org1.getActivity() > org2.getActivity())
//                    return -1;
//            else if (org1.getActivity() < org2.getActivity())
//                    return 1;
//            else
//            {
//                    if (org1.getOld() > org2.getOld())
//                            return -1;
//                    else if (org1.getOld() < org2.getOld())
//                            return 1;
//            }
//
//            return 0;
    }

    public void collision(Organism attacker, int x, int y)
    {
            map[x][y].collision(attacker);
    }

    public int checkOrganismPower(int x, int y)
    {
            if (map[x][y] != null)
            {
                    return map[x][y].getPower();
            }
            return 0;
    }

    public int checkOrganismActivity(int x, int y)
    {
            if (map[x][y] != null)
            {
                    return map[x][y].getActivity();
            }
            return 0;
    }

    public void humanDie()
    {
            human = false;
    }

    public boolean humanAlive()
    {
            return human;
    }

    public boolean game()
    {
            return play;
    }

    public void endGame()
    {
            play = false;
    }

    public void addComment(String org1, String action, String org2)
    {
            comments[comment_i] = org1 + " " + action + " " + org2;
            comment_i++;
            comment_i = comment_i % (COMMENTS_AMOUNT);
            comments[comment_i] = "*********************************";
    }
    
    public void addComment(String org1, String action)
    {
            comments[comment_i] = org1 + " " + action;
            comment_i++;
            comment_i = comment_i % (COMMENTS_AMOUNT+1);
            comments[comment_i] = "*********************************";
    }

    public void printComments()
    {
            for (int i = 0; i < COMMENTS_AMOUNT+1; i++)
            {
                    if(comments[i] != "")
                            System.out.println(comments[i]);
            }
    }

    //public void save()
    //{
    //	ofstream file("save.txt");
    //	file << width << " " << height<<endl;
    //	for (int i = 0; i < orgNum; i++)
    //	{
    //
    //	}
    //
    //}

}
