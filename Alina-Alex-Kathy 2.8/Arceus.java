import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arceus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arceus extends Pokemon
{
    //Stats for Pokemon
    private static String name = "Arceus";
    private int level;
    private static int evolutionForm = 1;
    private static int statPreset= 5;
    private static String[] moveSet = {"Celestial Spiral","Geometry","Magic Laser","Fire Ball"};

    //Misc
    private boolean enemy;
    private static int width = 200;
    private static int height = 200;

    public Arceus(int level, boolean enemy){
        super(name, level, statPreset, moveSet, evolutionForm, width, height, enemy);
    }  
}
