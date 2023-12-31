import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moving_Platforms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moving_Platforms extends Platforms
{
    private int sX=1;//Direction of the movement (Positive - right) (Negative - left) on axis X
    /**
     * Act - do whatever the Moving_Platforms wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //nothing
    }
    //Overriding 
    public void platformSize() 
    {
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/4);//Scale the original image
    }
    /*xLimit how much from the border do we want to go 
    xLimit to  720-xLimit*/
    //@Overloading
    public void movingPlatforms(int xLimit) //int 122
    {
        move(3*sX);//Move 3 units in a direction (sX) {-1 negative; +1 posite on X axis}
        if(getX()>getWorld().getWidth()-xLimit)
            sX=-1;//change diretction
        if(getX()<xLimit)
            sX=1;//change diretction
    }
    //@Overloading
    public void movingPlatforms(double xLimit) // double 122.2
    {
        move(3*sX);//Move 3 units in a direction (sX) {-1 negative; +1 posite on X axis} 
        if(getX()>getWorld().getWidth()-xLimit)
            sX=-1;//change diretction
        if(getX()<xLimit)
            sX=1;//change diretction
    }
}
