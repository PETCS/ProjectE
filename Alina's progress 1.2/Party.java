//////////////// PARTY INTERFACE ////////////////

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class Party extends Actor
{
    boolean init = true;
    MyWorld world;
    ///////////
    ArrayList<Pokemon> pokemons;

    // hashmaps of _item name_ and _item quantity_ are in a list (to hold multiple name-quantity pairs), and there are multiple such lists for each category of items

    String itemChosen;

    public Party() {
        
        ///
        this.getImage().scale(800, 600);
    }

    public void act() 
    {
        prepare(listLocations());
    }   

    // initialises world, then prepares by creating the category choice bar of the bag
    public void prepare(int[][] itemLocations) {
        if(init) {
            world = (MyWorld)getWorld();
            init = false;
            ///////

        }
    }

    private int[][] listLocations() {
        // location of the future ItemsList object (derived from first item location again in BagCategories class)
        int itemX = 400;
        int itemY = 200;

        // list all the possible (maximum) y values in order
        int itemY1 = itemY - 60;
        int itemY2 = itemY1 + 40;
        int itemY3 = itemY2 + 40;
        int itemY4 = itemY3 + 40;
        
        int itemX1 = itemX - 200;
        int itemX2 = itemX1;
        int itemX3 = itemX + 200;
        int itemX4 = itemX3;
        int[][] itemLocations = {{itemX1, itemY1}, 
                {itemX2, itemY2}, 
                {itemX3, itemY3}, 
                {itemX4, itemY4}};

        return itemLocations;
    }

    public void itemChosen(String item) {
        itemChosen = item;
        removeEverything();
    }

    // this method is used to check (from the player class) whether an item is chosen (not null), at which point the item name will be deciphered in its own class (maybe same Item class) for properties and used on Pokemon
    public String itemChosen() {
        if(itemChosen == null)  
            return null;
        else {
            removeEverything();
            return itemChosen;
        }
    }

    public void removeEverything() {
        ArrayList<Class> bagClasses = new ArrayList<>();
        bagClasses.add(Selection.class); // itemselection checks for objects of other classes in its act(), so should be removed first
        bagClasses.add(BagCategories.class);
        bagClasses.add(ItemsList.class);
        bagClasses.add(Item.class);
        bagClasses.add(ItemDescription.class);
        for(Class c: bagClasses)
            world.removeObjects(world.getObjects(c));
        world.removeObject(this);
    }
}