import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jigglypuff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jigglypuff extends Pokemon
{
    //Stats for Pokemon
    private static String name = "Jigglypuff";
    private int level;
    private static int evolutionForm = 1;
    private static int statPreset= 4;
    private static String[] moveSet = {"Heal", "Celestial_spiral", "Purp_blast", "Lightning_bolt"};
    
    
    //Misc
    private boolean enemy;
    private static int width = 150;
    private static int height = 150;
    
    public Jigglypuff(int level, boolean enemy){
        super(name, level, statPreset, moveSet, evolutionForm, width, height, enemy);
    }
    
    /**
     * Act - do whatever the Jigglypuff wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     
    public void act() 
    {
        // Add your action code here.
    }*/
}
