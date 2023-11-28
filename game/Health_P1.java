import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health_P1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health_P1 extends Health
{
    private GreenfootImage [] health_P1; //array used to store images
    /**
     * Act - do whatever the Health_P1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentHealth();
    }
    /**
     * Health_P1 Construtor
     * Importing the images needed to the array
     */
    public Health_P1()
    {
        //Creating an array.
        health_P1 = new GreenfootImage [3];
        //Putting the images in.
        health_P1[0]= new GreenfootImage("p1_Heart_3.png");
        health_P1[1]= new GreenfootImage("p1_Heart_2.png");
        health_P1[2]= new GreenfootImage("p1_Heart_1.png");
        //Setting up the starting image
        setImage(health_P1[0]);
    }
    public void currentHealth()
    {
        if(Player1.getP1Health() == 2) 
            setImage(health_P1[1]);
        if(Player1.getP1Health() == 1)
            setImage(health_P1[2]);
        if(Player1.getP1Health() == 0)
            gameOver();//end Screen
    }
}
