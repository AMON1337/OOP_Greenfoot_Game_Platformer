import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu_Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu_Buttons extends Actor
{
    /**
     * Act - do whatever the Menu_Buttons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Nothing
    }
    /**
     * clickSound - Method to make a sound when you click any button in menu
     */
    protected void clickSound()
    {
        if(Greenfoot.mouseClicked(this))
            Greenfoot.playSound("MenuClick.mp3"); 
    }
}
