import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform_Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform_Grass extends Moving_Platforms
{
    /**
     * Act - do whatever the Platform_Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movingPlatforms(111.111);
    }
    public Platform_Grass()
    {
        platformSize();
    }
    @Override 
    public void platformSize() 
    {
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/5);
    }
}
