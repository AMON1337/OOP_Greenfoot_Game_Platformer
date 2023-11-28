import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health_P2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health_P2 extends Health
{
    private GreenfootImage [] health_P2;//array used to store images
    /**
     * Act - do whatever the Health_P2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentHealth();
    }
    /**
     * Health_P2 Construtor
     * Importing the images needed to the array
     */
    public Health_P2()
    {
        //Creating an array.
        health_P2 = new GreenfootImage [3];
        //Putting the images in.
        health_P2[0]= new GreenfootImage("p2_Heart_3.png");
        health_P2[1]= new GreenfootImage("p2_Heart_2.png");
        health_P2[2]= new GreenfootImage("p2_Heart_1.png");
        //Setting up the starting image.
        setImage(health_P2[0]);
    }
    public void currentHealth()
    {
        if(Player2.getP2Health() == 2)
            setImage(health_P2[1]);
        if(Player2.getP2Health()== 1)
            setImage(health_P2[2]);
        if(Player2.getP2Health() == 0)
            gameOver();//end Screen method in Health.class
    }
}
