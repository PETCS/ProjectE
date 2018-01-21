import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Articuno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Articuno extends Pokemon
{
    //Stats for Pokemon
    private static String name = "Articuno";
    private int level;
    private static int evolutionForm = 1;
    private static int statPreset= 2;
    private static String[] moveSet = {"Celestial_spiral","Heal","Ice_shard","Beam"};
    
    
    //Misc
    private boolean enemy;
    private static int width = 150;
    private static int height = 150;
    
    public Articuno(int level, boolean enemy){
        super(name, level, statPreset, moveSet, evolutionForm, width, height, enemy);
    }
}
