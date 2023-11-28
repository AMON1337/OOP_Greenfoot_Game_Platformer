
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trash_Can here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trash_Can extends Trash
{
    /**
     * Act - do whatever the Trash_Can wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drop();
    }
    public Trash_Can()
    {
        getImage().scale(45,55);  
    }
    //Overloding
    public Trash_Can(int xScale,int yScale)
    {
        getImage().scale(xScale,yScale);
        setRotation(5);
    }
}
