import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu_How_To_Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu_How_To_Play extends World
{
    /**
     * Constructor for objects of class Menu_How_To_Play.
     * 
     */
    public Menu_How_To_Play()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        //Set background with the instructions of how to play the game
        setBackground(new GreenfootImage("Menu_How_To_Play.jpg"));
        //add a Back button to return to the Menu
        addObject(new Back(),111,55);
    }
}
