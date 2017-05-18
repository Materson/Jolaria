/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Worlds;
import java.util.Random;
import jolaria.Organism;
import Animals.*;
import Interface.RightBar;
import Plants.*;
import java.util.List;
import java.util.LinkedList;
import jolaria.Position;
import java.io.*;
import java.io.PrintWriter;
/**
 *
 * @author Materson
 */
public class World  {
//#include"IncludeOrganisms.h"

    private final int height, width;
    private int orgNum = 0;
    private boolean human, play;
    private String[] comments = new String[10];
    private int comment_i;
    private Organism[][] map;
    private List<Organism>[] order;
    private static final int COMMENTS_AMOUNT = 10;
    private static final int FILL_RATIO = 5;
    private RightBar menu;

    public World(int width, int height, RightBar menu)
    {
            this.menu = menu;
            this.width = width;
            this.height = height;
            map = new Organism[width][height];
            comment_i = 0;
            human = false;
            order= new List[8];
            for(int i=0; i< order.length; i++)
            {
                order[i] = new LinkedList<Organism>();
            }
            fillWorld();
            drawWorld();
    }
    
    public Organism getOrganism(int x, int y)
    {
        return map[x][y];
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
        for (int i = 7; i >= 0; i--)
        {
            if(order[i].size() == 0)
            {
                continue;
            }
            
            for(int j=0; j<order[i].size(); j++)
            {
                if (order[i] != null)
                        order[i].get(j).increaseOld();
            }
        }
        
        for (int i = 7; i >= 0; i--)
        {
            if(order[i].size() == 0)
            {
                continue;
            }
            
            for(int j=0; j<order[i].size(); j++)
            {
                order[i].get(j).action();
            }
        }
    }

    public void drawWorld()
    {
    	//system("cls");
    	System.out.println( "Mateusz Szymanowski, nr:165319");
    	for (int i = 0; i <= height * 2; i++)
    	{
    		for (int j = 0; j <= width * 2; j++)
    		{
    			if (i % 2 == 0 && j%2 == 0) System.out.print("+");
    			else if (i % 2 == 0 && j % 2 == 1) System.out.print("-");
    
    			if (i % 2 == 1 && j % 2 == 0)System.out.print("|");
    			if (i % 2 == 1 && j % 2 == 1)
    			{
    				if (map[j / 2][i / 2] == null)
    					System.out.print(" ");
    				else
    					map[j / 2][i / 2].draw();
    			}
    		}
    		System.out.println();
    	}
    	printComments();
        System.out.print("\033[H\033[2J");
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
    public boolean findFreeSpace(Position pos, int range)
    {
            int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
            int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

            for (int j = 1; j <= range; j++)
            {
                    for (int i = 0; i < dx.length; i++)
                    {
                            char place = checkPlace((pos.x) + (dx[i] * j), (pos.y) + (dy[i] * j));
                            if (place == '!' || place != ' ')
                                    continue;

                            pos.x += (dx[i] * j);
                            pos.y += (dy[i] * j);
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
                    order[5].add(map[x][y]);
                    break;
            case 's':
                    map[x][y] = new Sheep(4, 4, this, x, y);
                    order[4].add(map[x][y]);
                    break;
            case 'f':
                    map[x][y] = new Fox(3, 7, this, x, y);
                    order[7].add(map[x][y]);
                    break;
            case 't':
                    map[x][y] = new Turtle(2, 1, this, x, y);
                    order[1].add(map[x][y]);
                    break;
            case 'a':
                    map[x][y] = new Antelope(4, 4, this, x, y);
                    order[4].add(map[x][y]);
                    break;
            case 'H':
                    map[x][y] = new Human(5, 5, this, x, y);
                    order[5].add(map[x][y]);
                    break;
            case 'g':
                    map[x][y] = new Grass(0, this, x, y);
                    order[0].add(map[x][y]);
                    break;
            case 'm':
                    map[x][y] = new Milk(0, this, x, y);
                    order[0].add(map[x][y]);
                    break;
            case 'G':
                    map[x][y] = new Guarana(0, this, x, y);
                    order[0].add(map[x][y]);
                    break;
            case 'b':
                    map[x][y] = new Berry(99, this, x, y);
                    order[0].add(map[x][y]);
                    break;
            case 'X':
                    map[x][y] = new Borscht(10, this, x, y);
                    order[0].add(map[x][y]);
                    break;
            default:
                    map[x][y] = null;
                    orgNum--;
                    break;
            }
            orgNum++;
    }

    public void fillWorld()
    {
            String organism = "abXHfgGmstw";
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
                                    addComment("H", "created");
                                    human = true;
                            }
                            organism = organism.replace('H', ' ');
                            break;
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
        int activity = org.getActivity();
        for (int i = 0; i < order[activity].size(); i++)
        {
                if (order[activity].get(i) == org)
                {
                        order[activity].remove(i);
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
            menu.addComment(org1 + " " + action + " " + org2);
    }
    
    public void addComment(String org1, String action)
    {
            comments[comment_i] = org1 + " " + action;
            comment_i++;
            comment_i = comment_i % (COMMENTS_AMOUNT);
            comments[comment_i] = "*********************************";
            menu.addComment(org1 + " " + action);
    }

    public void printComments()
    {
            for (int i = 0; i < COMMENTS_AMOUNT; i++)
            {
                    if(comments[i] != "")
                            System.out.println(comments[i]);
            }
    }

    public String prepareSave()
    {
    	String text = new String();
        text += width+" "+height+" "+orgNum;
        
        for (int i = 7; i >= 0; i--)
        {
            if(order[i].size() == 0)
            {
                continue;
            }
            
            for(int j=0; j<order[i].size(); j++)
            {
                Organism org = order[i].get(j);
                text += " "+String.valueOf(org.getImage()) + " " + String.valueOf(org.getX()) + " " + String.valueOf(org.getY()) + " " + String.valueOf(org.getPower()) + " " + String.valueOf(i) + " " + String.valueOf(org.getOld());
                if(org instanceof Human)
                {
                    text += org.getSkill();
                }
            }
        }
        
        return text;
    }
    
    public void saveFile()
    {
        try{
            PrintWriter file = new PrintWriter("save.txt");
            file.println(prepareSave());
            file.close();
            
        } catch(IOException e)
        {
            break;
        }
    }

}
