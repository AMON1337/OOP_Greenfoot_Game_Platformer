import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform_Wood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform_Wood extends Basic_Platforms
{
    /**
     * Act - do whatever the Platform_Wood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //nothing
    }
    public Platform_Wood()
    {
        platformSize();
    }
    //Overriding
    public void platformSize()
    {
        getImage().scale(50,50);
    }
}
