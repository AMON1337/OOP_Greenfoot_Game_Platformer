import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Players
{
    private GreenfootImage [] p2_Run; //Array for player 2 run animations
    private GreenfootImage p2_Jump; //Player 2 jump "animation" (Image)
    private GreenfootImage p2_Idle; //Player 2 idle "animation" (Image)
    private static int p2_CurrentHealth; //Player 2 Health bar
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Movement and Physics
        movement("d","a","w");// Setting the controls for movement
        onPlatforms(); //Check if on Platforms.
        checkFalling(); // Check if is falling.
        
        //Animations
        run_Anim(p2_Run,p2_Idle);//Animate P2 while running
        jump_Anim(p2_Jump);//Animate the jump 
        
        //Score
        collect();
        
        //Health

        damageTaken();
        
        
        //Trash to collect
        spawnTrash(); //spawns Trash_Can() @Override 
    }
    /** 
     * Construtor of Player2
     */
    public Player2()
    {
        //Animations.
        run_Anim(); //Creating an array of images for running.
        jump_Idle_Anim();//Creating an  image for jumping and for idleing.
        setImage(p2_Run[0]); //Setting the starting image.
        
        //Setting up Player 2
        isMoving= false; //Player 2 also starts the game still.
        isPlayerDirection= true; //Starts the game in the positive direction
        p2_CurrentHealth=3; //Player 2 starts the game with full health
    }
    /** 
     * Player 2 Run Animations! 
     * 
     */
    public void run_Anim()
    {
        // Creating the array.
        p2_Run = new GreenfootImage [20];
        //Putting all the walking images in.
        p2_Run[0] = new GreenfootImage("p2_Run_(1).png");
        p2_Run[1] = new GreenfootImage("p2_Run_(2).png");
        p2_Run[2] = new GreenfootImage("p2_Run_(3).png");
        p2_Run[3] = new GreenfootImage("p2_Run_(4).png");
        p2_Run[4] = new GreenfootImage("p2_Run_(5).png");
        p2_Run[5] = new GreenfootImage("p2_Run_(6).png");
        p2_Run[6] = new GreenfootImage("p2_Run_(7).png");
        p2_Run[7] = new GreenfootImage("p2_Run_(8).png");
        p2_Run[8] = new GreenfootImage("p2_Run_(9).png");
        p2_Run[9] = new GreenfootImage("p2_Run_(10).png");
        p2_Run[10] = new GreenfootImage("p2_Run_(11).png");
        p2_Run[11] = new GreenfootImage("p2_Run_(12).png");
        p2_Run[12] = new GreenfootImage("p2_Run_(13).png");
        p2_Run[13] = new GreenfootImage("p2_Run_(14).png");
        p2_Run[14] = new GreenfootImage("p2_Run_(15).png");
        p2_Run[15] = new GreenfootImage("p2_Run_(16).png");
        p2_Run[16] = new GreenfootImage("p2_Run_(17).png");
        p2_Run[17] = new GreenfootImage("p2_Run_(18).png");
        p2_Run[18] = new GreenfootImage("p2_Run_(19).png");
        p2_Run[19] = new GreenfootImage("p2_Run_(20).png");
        //Scaling down the array of images p2_Run
        for(index=0;index != 20;index++)
        {
            p2_Run[index].scale(75,75);
        }
    }
    /** 
     * Method used to create and scale down the image used for jumping
     * 
     */ 
    public void jump_Idle_Anim()
    {
        //Jump Animations
        p2_Jump = new GreenfootImage("p2_Jump.png");
        p2_Jump.scale(75,75); //Scaling down the jump image.
        p2_Idle= new GreenfootImage("p2_Idle.png");
        p2_Idle.scale(75,75); //Scaling down the jump image.
    }
    /** 
     * Method calculate the damage taken to update the health bar!
     * 
     */ 
    public void damageTaken()
    {
        if(isTouching(Enemies.class)) 
        {
            if(isTouchingEnemy==true) // isTouching
            {
                p2_CurrentHealth = p2_CurrentHealth - 1; //current health - 1
                isTouchingEnemy=false; //stops from taking to much damage
                Greenfoot.playSound("HitSound.mp3"); //play sound
            }
        } 
        else
        {
            isTouchingEnemy=true;//reset the variable to be able to take damage again
        }
        if(getY()>710)//Lose health if hit the bottom of the map
        {
           p2_CurrentHealth = p2_CurrentHealth - 1;
           isMoving= false; //stops movement
           setLocation(280,620);//starting positon for player
           Greenfoot.playSound("HitSound.mp3");
        }
    }
    public static int getP2Health()
    {
        return p2_CurrentHealth;
    }
    @Override 
    public void spawnTrash()
    {
        if(Greenfoot.getRandomNumber(1000)<1) //0 to 999 random; 1/1000 chance
        {
            //Trash_Can size is more than 40 on X and 50 on Y the addiction amount in both axis is randomize
            Trash_Can TrashSpawn = new Trash_Can(Greenfoot.getRandomNumber(16)+40,Greenfoot.getRandomNumber(16)+50); //0-15 random + 40 fixed (on width) or 50 fixed (on height)
            // X between 100 and 1180, can spawn Trash_Can()
            getWorld().addObject(TrashSpawn,Greenfoot.getRandomNumber(1081)+100,0); 
        }
    }
}
