import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Nothing
    }
    /**
     * Construtor 
     * it is used to create a mask over the game to simulate an ending for the game
     * no need to create another world to this purpose.
     */
    public GameOver()
    {
        if (getWorldOfType(Mission1.class).getScore()<5000) //if score less than 5000 points players lose
        {
            setImage("GameOver_Lose.jpg");
            Greenfoot.playSound("GameOver.mp3");
        }
        else //if score more than 5000 points players win
        {
            setImage("GameOver_Win.jpg");
            Greenfoot.playSound("GameOverWin.mp3");
        }
    }           
}
