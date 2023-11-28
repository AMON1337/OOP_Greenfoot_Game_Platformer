import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class How_To_Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class How_To_Play extends Menu_Buttons
{
    /**
     * Act - do whatever the How_To_Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clickSound();
        click();
    }
    //If we mouseClicked change world.
    private void click()
    {
        if(Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new Menu_How_To_Play());
    }
}
