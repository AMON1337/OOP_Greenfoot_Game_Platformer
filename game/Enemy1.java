import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemies
{
    private int rotation; //used to rotate the enemy
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fall(); //move down on Y axis!
    }
    /**
     * Construtor of Enemy 1
     */
    public Enemy1()
    {
        getImage().scale(25,25); //Scaling down
        rotation = 0; //Starting rotation 0;
    }
    /**
     * Fall() - Method used to move the enemy in the Y axis and also rotate him. Gives the enemy movement
     */
    public void fall()
    {
        setLocation(getX(),getY()+3);//Move 5 units on Y (Falling)
        setRotation(rotation); // set rotation starts at 0, +5 for every cicle. 
        rotation = rotation +5; // previous rotation + 5 
        if(getY()>710) //at Y>710 
            getWorld().removeObject(this); // Remove the object
    }
}
