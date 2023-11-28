import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (Filipe Lopes && Daniel Lopes) 
 * @version (03/11/20)
 */
public class Menu extends World
{
    /**
     * Constructor for objects of class Menu.
     */
    public Menu()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        //Sets the menu background
        setBackground(new GreenfootImage("Menu_Background.jpg"));
        //Add Buttons
        addObject(new Play(),getWidth()/2,175);
        addObject(new How_To_Play(),getWidth()/2,420);
        addObject(new Controls(),getWidth()/2,525);
    }
}

