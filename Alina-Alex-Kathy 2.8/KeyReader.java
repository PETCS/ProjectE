import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyReader extends Actor
{
    private String key;

    public void act() {
        key = null;
        key = Greenfoot.getKey();
    }

    public boolean keyIs(String s) {
        return s.equals(key);
    }
}

