import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu_Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu_Controls extends World
{
    /**
     * Constructor for objects of class Menu_Controls.
     */
    public Menu_Controls()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        //Set backgorund with the controls
        setBackground(new GreenfootImage("Menu_Controls.jpg"));
        //adds a back button to return to the Menu
        addObject(new Back(),111,55);
    }
}
