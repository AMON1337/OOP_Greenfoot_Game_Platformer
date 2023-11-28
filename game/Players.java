import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will have the basic set of moves that the players will have!
 * 
 */

public class Players extends Actor
{
    //Players Physics (JUMP && FALL) 
    private int vSpeed=0; //Vertical Speed
    private final int ACCELERATION = 1; //Acceleration on the jump, doesn't change
    private int jumpHeight = -17; //How hight the jump is
    //Players Movement, checking movement and direction for animations
    protected boolean isMoving; //Check if Player1 is moving, used on animation methods.
    protected boolean isPlayerDirection; //What direction on X is the Player 1 moving; true=Positive (X), false=negative (-X)
    //Players Animations
    protected int index; //Index used to check positions in arrays
    //Enemies
    protected boolean isTouchingEnemy=false; //check if is touchin enemy
    /**
     * Act - do whatever the Players wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Nothing
    }
    /** 
     * Player Movement
     * This can be access by both players 
     */
    //Basic method for movement that can be used by both players
    public void movement(String keyRight,String keyLeft,String keyJump)
    {   
        //Stops the animation if not moving.
        isMoving = false; 
        //Moving to the right on X
        if (Greenfoot.isKeyDown(keyRight))
        {
            isMoving = true;
            isPlayerDirection= true;
            move(4);
        }
        // Loving to the left on X
        if (Greenfoot.isKeyDown(keyLeft))
        {
            isMoving = true;
            isPlayerDirection= false;
            move(-4);
        }
        //Jump only if on a Platform! 
        if (Greenfoot.isKeyDown(keyJump)&&onPlatforms()==true)
        {
            vSpeed=jumpHeight;
            gravity();
        }
    }
    /** 
     * Players Physics  (JUMP && FALL)   
     */
    //this will send the Player can to the ground when in the air. The accelaration will make the fall faster the higher the player is.
    protected void gravity()
    {   
        setLocation(getX(), getY() + vSpeed); //Will increase only value of Y by vSpeed amounts.
        vSpeed= vSpeed + ACCELERATION; //Adding acceleration(1) to vSpeed to make players fall faster over time
    }
    //Method that checks if the Actors (Players) are on platforms.
    protected boolean onPlatforms()
    {                                   //Width= 0 (X) ,Height/2 (Y)- getImage().getHeight()/2, applying to the class Platforms
        Actor onPlatform = getOneObjectAtOffset(0,getImage().getHeight()/2,Platforms.class);
        return onPlatform !=null; // returns only if diffent from null
    }
    //Using the Previous methods to "enable" and "disable" gravity when needed.
    public void checkFalling()
    {
        if(onPlatforms()==false)// if not on Platforms enable gravity().
        gravity();
        //need to reset the vSpeed because it would increase to infinite doing multiple jumps.
        else
        vSpeed=0;
    }
    /** 
     * Players Run Animation
     * This is used to loop the array of animetion to create
     * the illusion of running.
     */
    //Run an Idle animations
    public void run_Anim(GreenfootImage run[],GreenfootImage idle)
    {
        if(isMoving)//if player is moving
        {
            index++;//array of image +1
            if (index >=run.length)//Resets the array to index 0 to loop the animation
            index=0;
            //Run Animations
            GreenfootImage displayImage = new GreenfootImage(run[index]);//temp variable to store the current image of the array
            if(isPlayerDirection==false)//if moving left
            displayImage.mirrorHorizontally(); //mirror the current image

            setImage(displayImage); //Display the current image mirror or not.
        }   
        else //If not moving then the Player is idle
        {
            GreenfootImage displayImage= new GreenfootImage(idle); //Temp varable to store the idle image 
            if(isPlayerDirection==false) //if player moving left
            displayImage.mirrorHorizontally(); // mirror jump image
            
            setImage(displayImage);// display current jump image, mirror or not.
         }
        }
    /** 
     * Players Jump Animation
     * This is simpler, we just used one image so if the player is not on a platforms 
     * then play the jump/falling image "animation"
     * 
     */
    //Jump animation
    public void jump_Anim(GreenfootImage jump)
    {
        if(onPlatforms()==false)// If not on Platform
        { 
            GreenfootImage displayImage= new GreenfootImage(jump); //displayImage temp variable to store jump image
            if(isPlayerDirection==false) //if moving left
            displayImage.mirrorHorizontally();//Flip jump image
            
            setImage(displayImage); //display jump image mirror or normal.
        } 
    }
    /** 
     * Methods to spawn Trash
     * This method makes more to be in Mission.class but the did it here so we can
     * implement this version on Player1
     * and Override the method on Player2 
     * to exemplify the function @Override
     */
    public void spawnTrash()
    {
        if(Greenfoot.getRandomNumber(100)<1) //0 to 99 random 1/100 chance
        {
            // X between 100 and 1180 that can spwan trash
            getWorld().addObject(new Trash_Drop(),Greenfoot.getRandomNumber(1081)+100,0); 
        }
    }
    /** 
     * Methods to add Points to SCORE!
     * addScore Method on Mission1 World
     */
    public void collect()
    {
        if(isTouching(Trash_Can.class))
        {
            getWorldOfType(Mission1.class).addScore(Greenfoot.getRandomNumber(101)+125); //0-100 random + 125 fixed
            removeTouching(Trash_Can.class);
            Greenfoot.playSound("CollectSound.mp3");
        }
        if(isTouching(Trash_Drop.class))
        {
            getWorldOfType(Mission1.class).addScore(Greenfoot.getRandomNumber(26)+35); //0-25 random + 35 fixed
            removeTouching(Trash_Drop.class);
            Greenfoot.playSound("CollectSound.mp3");
        }
    }
}

