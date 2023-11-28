import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trash extends Actor
{
    /**
     * Act - do whatever the Trash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //nothing
    }
     /**
     * drop - if Trash isn't touching any platform and +5 to Y, to move the object down
     * if Y>710 remove the object and remove -50 points from score.
     */
    public void drop()
    {
        if(!isTouching(Platforms.class))
        {
            setLocation(getX(),getY()+5);//Move 5 units on Y (Falling)
        }
        if(getY()>710) //at Y>710 players did catch the trash
        {
            getWorldOfType(Mission1.class).addScore(-75); //"add" -50 to Score
            getWorld().removeObject(this); // Remove the object
        }
    }
}
