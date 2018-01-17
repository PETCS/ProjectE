//////////////// BAG INTERFACE ////////////////

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class Bag extends Actor
{
    boolean init = true;
    MyWorld world;
    ///////////
    BagCategories categories;

    // the list of all items in bag (get this from world)
    ArrayList<HashMap<String, Integer>> itemList = new ArrayList<HashMap<String, Integer>>();

    // 2d array of coordinates of all the item locations (taken from ItemsList constructor declaration)
    String itemChosen;
    public Bag() {//ArrayList<HashMap<String, Integer>> itemList) {
        ///
        this.getImage().scale(800, 600);
    }

    public void act() 
    {
        prepare(listLocations());
    }   

    // initialises world, then prepares by creating the vategory choice bar of the bag
    public void prepare(int[][] itemLocations) {
        if(init) {
            world = (MyWorld)getWorld();
            init = false;
            ///////

            itemList = world.getBag();
            categories = new BagCategories(itemList, itemLocations, 100, 300); // this is where location of category object is chosen
            world.addObject(categories, 0, 0);
        }
    }

    private int[][] listLocations() {
        //boolean if statement here for whether it's bag or party

        // location of the future ItemsList object (derived from first item location again in BagCategories class)
        int itemX = 515;
        int itemY = 225;

        // list all the possible (maximum) y values in order
        int itemY1 = 68;
        int itemY2 = itemY1 + 42;
        int itemY3 = itemY2 + 42;
        int itemY4 = itemY3 + 42;
        int[][] itemLocations = {{itemX, itemY1}, 
                {itemX, itemY2}, 
                {itemX, itemY3}, 
                {itemX, itemY4}};

        return itemLocations;
    }

    // updates the amount of an item in the bag, deletes the item if amount is less than 1
    public void remapItem(String name, int amount) {
        for(HashMap<String, Integer> map : itemList) {
            for(String key : map.keySet()) {
                if(key.equals(name)) { // find correct item key
                    map.put(key, amount);
                    if(amount < 1) {
                        map.remove(key); // remove the mapping of such item if no more left
                    }
                    amount = -1; // indicator for outer loop to break after this
                    break;
                }
            }
            if(amount == -1) break;
        }
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
        ArrayList<Class> bagClasses = new ArrayList<Class>();
        bagClasses.add(Selection.class); // itemselection checks for objects of other classes in its act(), so should bed first
        bagClasses.add(BagCategories.class);
        bagClasses.add(ItemsList.class);
        bagClasses.add(Item.class);
        bagClasses.add(ItemDescription.class);
        for(Class c: bagClasses)
            world.removeObjects(world.getObjects(c));
        world.setBag(itemList);
        world.removeObject(this);
    }
}
