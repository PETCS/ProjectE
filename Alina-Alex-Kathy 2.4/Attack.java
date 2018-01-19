import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Move
{
    private String name;
    private int damage;
    private int speed;
    private Pokemon attacker;
    private boolean enemy;
    private int targetX;
    private int targetY;
    public Attack(String name, int damage, int speed, Pokemon attacker, boolean enemy, int targetX, int targetY){
        super(name, enemy);
        this.name = name;
        this.damage = damage;
        this.speed = speed;
        this.attacker = attacker;
        this.targetX = targetX;
        this.targetY = targetY;

        turnTowards(targetX, -targetY);
    }

    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(speed);
        //keep it in domain

        if(getX() > getWorld().getWidth()-5 || getX() < 5 || getY() > getWorld().getHeight()-5) {
            //if(((Stages)getWorld()).getTurn() == 3)
            //((Stages)getWorld()).nextTurn();
            getWorld().removeObject(this);
        }
        else
            hit();
    }    

    public void hit() {
        Pokemon pokemon = (Pokemon)getOneObjectAtOffset(0,0, Pokemon.class);
        int damageInflicted = (int)(attacker.getAttack() * (damage * 0.1 + 1)); 
        if(pokemon != null && pokemon != attacker){
            pokemon.getHit(damageInflicted);
            if(pokemon.getCurHealth() <= 0) {
                attacker.expToLevelUpChange(-pokemon.getExp());
            }
            //((Stages)getWorld()).nextTurn();

            changeTurn();
            getWorld().removeObject(this);
        }
    }

    public int getDamage(){
        return damage;
    }

    public int getSpeed(){
        return speed;
    }
}
