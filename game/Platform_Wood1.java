import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform_Wood1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform_Wood1 extends Moving_Platforms
{
    /**
     * Act - do whatever the Platform_Wood1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movingPlatforms(300); //xLimit=300        
    }
    public Platform_Wood1()
    {
        platformSize();
    }
}
