import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MagicBlast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicLaser extends Attack
{
    private static String name = "Magic Laser";
    private static int damage = 12;
    private static int speed = 5;
    private Pokemon attacker;
    private boolean enemy;
    private int targetX;
    private int targetY;
    public MagicLaser(Pokemon attacker, boolean enemy, int targetX, int targetY){
        super(name, damage, speed, attacker, enemy, targetX, targetY);
        
    }      
}
