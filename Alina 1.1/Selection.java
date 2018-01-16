////////////////  INTERFACE ////////////////

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Selection extends Actor
{
    boolean init = true;
    MyWorld world;
    KeyReader keys;
    //////////

    String key;
    int[] gridIndex = {0, 0}; // always starts at location 0
    Actor[][] grid;

    public Selection(ArrayList<Actor> objectList, boolean twoColumns) {
        if(twoColumns) { // if two columns, then the arraylist needs to be split into 2 arrays first
            Actor[] firstColumn, secondColumn;
            secondColumn = new Actor[objectList.size()/2];
            firstColumn = new Actor[objectList.size() - secondColumn.length];
            for(int i = 0; i < firstColumn.length; i++) // populate first and second column lists with the buttons
                firstColumn[i] = objectList.get(i);
            for(int i = 0; i < secondColumn.length; i++)
                secondColumn[i] = objectList.get(firstColumn.length + i);
            Actor[][] temp = {firstColumn, secondColumn};
            grid = temp;
            temp = null;
        }
        else { // if only one column, then grid consists of one array, to which the arraylist is just converted
            Actor[][] temp = {objectList.toArray(new Actor[objectList.size()])};
            grid = temp;
            temp = null;
        }
    }

    public void act() 
    {
        prepare();

        if(keys.keyNotNull()) {
            // see if second coordinate (y) is less than max index of current x coord-th array length in grid
            if(keys.keyIs("down") && gridIndex[1] < grid[gridIndex[0]].length - 1) 
                setLocation(grid[gridIndex[0]][++gridIndex[1]].getX(), grid[gridIndex[0]][gridIndex[1]].getY()); 
            else if(keys.keyIs("up") && gridIndex[1] > 0)
                setLocation(grid[gridIndex[0]][--gridIndex[1]].getX(), grid[gridIndex[0]][gridIndex[1]].getY());
            else if(keys.keyIs("right") && gridIndex[0] < grid.length - 1)
                setLocation(grid[++gridIndex[0]][gridIndex[1]].getX(), grid[gridIndex[0]][gridIndex[1]].getY());
            else if(keys.keyIs("left") && gridIndex[0] > 0) 
                setLocation(grid[--gridIndex[0]][gridIndex[1]].getX(), grid[gridIndex[0]][gridIndex[1]].getY());
            grid[gridIndex[0]][gridIndex[1]].hoverOver(); // let the hovered over object do whatever it does before being selected
            //if(keys.keyIs("enter"))
            //buttonList.select(currentItem());
        }
    }

    private Item currentItem() {
        return world.getObjectsAt(getX(), getY(), Item.class).get(0);
    }

    public void prepare() {
        if(init) {
            world = (MyWorld)getWorld();
            keys = world.getKeys();
            init = false;
            /////////
        }
    }
}
