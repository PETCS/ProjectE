import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragonite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragonite extends Pokemon
{
    //Stats for Pokemon
    private static String name = "dragonite";
    private int level;
    private static int evolutionForm = 2;
    private static int statPreset= 6;
    private static String[] moveSet = {"Fire Ball", "Fire Ball", "Fire Ball", "Fire Ball"};
    
    
    //Misc
    private boolean enemy;
    private static int width = 50;
    private static int height = 50;
    
    public Dragonite(int level, boolean enemy){
        super(name, level, statPreset, moveSet, evolutionForm, width, height, enemy);
    }  
}
