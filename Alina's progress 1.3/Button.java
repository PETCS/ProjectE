import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 

/**
 * This class is used to make buttons that can be pressed, and 
 * that execute some command when pressed. Such a command is 
 * defined in child classes of the Button class.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class Button extends Actor
{       
    boolean init = true; // variable to allow you to initialise some actions
    MyWorld world; // this will keep track of the world (must be declared as instance variable)
    ///////////
    int x, y;
    public String name;

    boolean hovered;

    //quadrant button locations for battle screen
    int q3X = 660;
    int q3Y = 440;
    int q1X = 460;
    int q1Y = 440;
    int q2X = 460;
    int q2Y = 500;
    int q4X = 660;
    int q4Y = 500;

    //quadrants follow a sideways Z pattern: from top left down, then from top right down
    int[][] quadrants = {{q1X, q1Y}, {q2X, q2Y}, {q3X, q3Y}, {q4X, q4Y}};

    public void act() {
        prepare();

        MouseInfo info = Greenfoot.getMouseInfo(); // see what is being done with mouse
        if(Greenfoot.mouseClicked(this)) { // if this object is clicked
            select(); // execute appropriate method
        }       
    }

    public void whenHovered() {
        for(Button button : world.getObjects(Button.class)) {
            if(button.name != null) 
                button.setImage(button.name + "Button.png");
        }
        setImage(name + "ButtonHover.png");
    }

    // this method is called when the button is clicked. It is defined in the subclasses 
    // for functionality that is specific to that button type.
    public void select() {}

    // this method initialises world variable, and then does whatever needs to be done on instantiation 
    public void prepare() {
        if(init) {
            world = (MyWorld)getWorld();
            init = false;
            //////////
        }
    }
}
