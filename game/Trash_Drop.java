import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trash_Drop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trash_Drop extends Trash
{
    private GreenfootImage [] trashDrop;
    /**
     * Act - do whatever the Trash_Drop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drop();
    }
    public Trash_Drop()
    {
        //Starting image starts in the right size
        getImage().scale(35,35);
        // Creating the array.
        trashDrop= new GreenfootImage [2];
        //Putting all the walking images in.     
        trashDrop[0] = new GreenfootImage("Trash_Drop.png");
        trashDrop[1] = new GreenfootImage("Trash_Drop1.png");
        //Resizing the array
        trashDrop[0].scale(35,35);
        trashDrop[1].scale(35,25);
    }
    @Override 
    public void drop()
    {
        if(!isTouching(Platforms.class))
        {
            setLocation(getX(),getY()+5);//Move 5 units on Y (Falling)
            setImage(trashDrop[0]);
        }else
            setImage(trashDrop[1]);
        if(getY()>710) //at Y>710 players did catch the trash
        {
            getWorldOfType(Mission1.class).addScore(-55); //"add" -75 to Score
            getWorld().removeObject(this); // Remove the object
        }
    }
}
