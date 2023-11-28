import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Menu_Buttons
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clickSound();
        click();
    }
    //If we mouseClicked change world
    private void click()
    {
        if(Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new Mission1());//set new World
    }
}