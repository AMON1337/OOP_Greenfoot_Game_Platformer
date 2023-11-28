import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{
    private GreenfootImage [] p1_Run; //Array for player 1 run animations
    private GreenfootImage p1_Jump; //Player 1 jump "animation" (Image)
    private GreenfootImage p1_Idle; //Player 1 idle "animation" (Image)
    private static int p1_CurrentHealth;//Player 1 health bar
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Movement and Physics
        movement("right","left","up");//Method in Players for setting up keys to move
        onPlatforms(); //Check if on Platforms!
        checkFalling(); //Check if is falling 
        
        //Animations
        run_Anim(p1_Run,p1_Idle);//Method in Players using the Run Array for player 1 to animate
        jump_Anim(p1_Jump);//Animate the jump 
        
        //Score
        collect();
        
        //Health
        //Add player 1 with full health
        damageTaken();
        
        //Spawn
        spawnTrash(); //spawns Trash_Drop()
    }
    /** 
     * Construtor of Player1
     */
    public Player1()
    {
        //Animations
        run_Anim(); //Creating an array of images for running
        jump_Idle_Anim(); //Creating an  image for jumping and for idleing.
        setImage(p1_Run[0]); //Setting the starting image.

        //Setting up Player 1
        isMoving= false; //Player 1 starts the game still.
        isPlayerDirection= true; //Starts the game in the positive direction
        p1_CurrentHealth = 3; //Starts the game with 3 health
    }
    /** 
     * Player 1 Run Animations! 
     *
     */ 
    public void run_Anim()
    {
        // Creating the array.
        p1_Run = new GreenfootImage [15];
        //Putting all the walking images in.
        p1_Run[0] = new GreenfootImage("p1_Run_(1).png");
        p1_Run[1] = new GreenfootImage("p1_Run_(2).png");
        p1_Run[2] = new GreenfootImage("p1_Run_(3).png");
        p1_Run[3] = new GreenfootImage("p1_Run_(4).png");
        p1_Run[4] = new GreenfootImage("p1_Run_(5).png");
        p1_Run[5] = new GreenfootImage("p1_Run_(6).png");
        p1_Run[6] = new GreenfootImage("p1_Run_(7).png");
        p1_Run[7] = new GreenfootImage("p1_Run_(8).png");
        p1_Run[8] = new GreenfootImage("p1_Run_(9).png");
        p1_Run[9] = new GreenfootImage("p1_Run_(10).png");
        p1_Run[10] = new GreenfootImage("p1_Run_(11).png");
        p1_Run[11] = new GreenfootImage("p1_Run_(12).png");
        p1_Run[12] = new GreenfootImage("p1_Run_(13).png");
        p1_Run[13] = new GreenfootImage("p1_Run_(14).png");
        p1_Run[14] = new GreenfootImage("p1_Run_(15).png");
        //Scaling down the array of images p1_Run
        for(index=0;index != 15;index++)
        {
            p1_Run[index].scale(75,75);
        }
    }
    /** 
     * Method used to create and scale down the image used for jumping
     * 
     */ 
    public void jump_Idle_Anim()
    {
        //Jump Animations
        p1_Jump = new GreenfootImage("p1_Jump.png");
        p1_Jump.scale(75,75); //Scaling down the jump image.
        p1_Idle = new GreenfootImage("p1_Idle.png");
        p1_Idle.scale(75,75); //Scaling down the jump image.
    }
    /** 
     * Method calculate the damage taken to update the health bar!
     * 
     */ 
    public void damageTaken()
    {
        if(isTouching(Enemies.class))
        {
            if(isTouchingEnemy==true)
            {
                p1_CurrentHealth = p1_CurrentHealth - 1;//-1 current health
                isTouchingEnemy=false;//stops from taking to much damage
                Greenfoot.playSound("HitSound.mp3");
            }
        } 
        else
        {
            isTouchingEnemy=true;//reset the variable to be able to take damage again
        }
        if(getY()>710) //Lose health if hit the bottom of the map
        {
           p1_CurrentHealth = p1_CurrentHealth - 1; //-1 health
           isMoving= false; //Stops player
           setLocation(getWorld().getWidth()-280,620); //starting position
           Greenfoot.playSound("HitSound.mp3"); //play sound
        }
    }
    
    public static int getP1Health()
    {
        return p1_CurrentHealth;
    }
}
