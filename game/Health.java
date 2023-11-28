import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Nothing
    }
    /**
     * gameOver - When one player dies this method is called to setup the ending
     * screen 
     * 
     */
    public void gameOver()
    {
        getWorldOfType(Mission1.class).musicMission1(false);//stops Mission1 Music
        //Adds the end Screen!
        getWorld().addObject(new GameOver(),getWorld().getWidth()/2,getWorld().getHeight()/2);
        //Print finalScore
        getWorldOfType(Mission1.class).printScore();
        Greenfoot.delay(444);// stops the game fora short period of time to see the final score and message
        Greenfoot.setWorld(new Menu());//returns to the main Menu
    }
}
