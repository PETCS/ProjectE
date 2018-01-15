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
    ArrayList<PartyTag> tags = new ArrayList<>();
    ItemsList partyList;
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

            // if using the world to get something, do it in act method (not in constructor, when there is no world yet)
            for(Pokemon pokemon : world.getParty()) 
                tags.add(new PartyTag(pokemon)); 

            int itemsListX = itemLocations[0][0];
            int itemsListY = itemLocations[0][1] + 150; // revert back to reference location (first transformed to be y1 from y
            partyList = new ItemsList(tags, itemLocations, itemsListX, itemsListY); // first category of items array
            world.addObject(partyList, partyList.getX(), partyList.getY());
        }
    }

    private int[][] listLocations() {
        // location of the future ItemsList object (derived from first item location again in BagCategories class)
        int itemX = 500;
        int itemY = 300;

        // list all the possible (maximum) y values in order (sideways Z pattern)
        int item1Y, item2Y, item3Y, item4Y, item5Y;
        item1Y = item4Y = itemY - 150;
        item2Y = item5Y = item1Y + 150;
        item3Y = item2Y + 150;

        int item1X, item2X, item3X, item4X, item5X;
        item1X = item2X = item3X = itemX - 250;
        item4X = item5X = item1X + 250;

        int[][] itemLocations = {{item1X, item1Y}, 
                {item2X, item2Y}, 
                {item3X, item3Y}, 
                {item4X, item4Y},
                {item5X, item5Y}};

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