import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mission1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mission1 extends World
{
    //Needed to keep track of the score
    private static int score;
    //Creates a new greenfoot music that will be used to loop the music 
    private GreenfootSound gameMusic = new GreenfootSound("Mission1_Music.mp3");
    /**
     * Act - o whatever the Mission1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        spawnEnemies();//starts spawing enemies when the Constructor is finished until we load another world.
    }
    /**
     * Constructor for objects of class Mission1.
     * 
     */
    public Mission1()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        //Priority in drawing classes in order to preserve clarity
        setPaintOrder(GameOver.class,Health.class,Enemies.class,Players.class,Trash.class,Platforms.class);
        //Set mission1 Background
        setBackground(new GreenfootImage("Mission1_Background.jpg"));
        Greenfoot.setSpeed(50);// Game balanced and created at this speed!
        
        //SCORE
        score = 0; //starts with 0 score;
        //Show the incial score from the start
        showText("Score: " + score, getWidth()/2, 33);
        
        //Add Objects 
        prepare();
        
        //Music
        musicMission1(true);
    }
    /**
     * prepare - Method used to hard code platforms and starting players and Trash.
     */
    public void prepare()
    {
        //Add Players to the starting positions
        addObject(new Player1(),getWidth()-280,620);//right
        addObject(new Player2(),280,620);//left
        //Add Players Health
        addObject(new Health_P1(),getWidth()-66,33);
        addObject(new Health_P2(),66,33);
        //Add starting Bonus Trash
        addObject(new Trash_Can(),getWidth()/2,getHeight()/2+100);//Middle
        addObject(new Trash_Can(),getWidth()-20,getHeight()-75);//Bottom right
        addObject(new Trash_Can(),20,getHeight()-75);//Bottom left
        addObject(new Trash_Can(),getWidth()/2-455,getHeight()/2-50);//3 Platforms in the Left
        addObject(new Trash_Can(),getWidth()/2+455,getHeight()/2-50);// 3 Platforms in the Right
        
        //Starting Platforms
        addObject(new Platform_Dirt(),1000,710);
        addObject(new Platform_Dirt(),280,710);
        //Middle 5 Platforms 
        addObject(new Platform_Dirt2(),getWidth()/2,getHeight()/2+150);
        addObject(new Platform_Dirt2(),getWidth()/2+45,getHeight()/2+150);
        addObject(new Platform_Dirt2(),getWidth()/2+90,getHeight()/2+150);
        addObject(new Platform_Dirt2(),getWidth()/2-45,getHeight()/2+150);
        addObject(new Platform_Dirt2(),getWidth()/2-90,getHeight()/2+150);
        // 3 Platforms up in the Left
        addObject(new Platform_Dirt2(),getWidth()/2-500,getHeight()/2);
        addObject(new Platform_Dirt2(),getWidth()/2-455,getHeight()/2);
        addObject(new Platform_Dirt2(),getWidth()/2-410,getHeight()/2);
        // 3 Platforms up in the Right
        addObject(new Platform_Dirt2(),getWidth()/2+500,getHeight()/2);
        addObject(new Platform_Dirt2(),getWidth()/2+455,getHeight()/2);
        addObject(new Platform_Dirt2(),getWidth()/2+410,getHeight()/2);
        //Wood Platforms on the bottom left and right that has Trash_Can 
        addObject(new Platform_Wood(),getWidth()-25,getHeight()-25); //right
        addObject(new Platform_Wood(),25,getHeight()-25);//left
        //X moving Platforms on Bottom and middle
        addObject(new Platform_Wood1(),getWidth()/2,getHeight()-100);//Bottom of the map
        addObject(new Platform_Grass1(),getWidth()/2,getHeight()/2);// Middle of the map
        //X Moving 2 Platforms really high
        addObject(new Platform_Grass(),200/2,getHeight()/2-150);
        addObject(new Platform_Grass(),getWidth()-200/2,getHeight()/2-150);
    }
    /**
     * addScore - Method to add Points to SCORE!
     */
    public void addScore(int points)
    {
        score = score + points;
        showText("Score: " + score, getWidth()/2, 33);
    }
    /**
     * printScore - Method to print the final score at the end of the game.
     */
    public void printScore()
    {
        showText("Final Score: " + score, getWidth()/2,33);
    }
    /**
     * getScore - Method use to export the score value without breaking security 
     * score is a private and static variable
     */
    //getScore used in GameOver.class to choose the ending
    public static int getScore()
    {
        return score;
    }
    /**
     * musicMission1 - Mehod used to start and stops the Mission1 music
     */
    public void musicMission1(boolean isMusicPlaying)
    {
        //Creates a new greenfoot music that will be used to loop the music
        if(isMusicPlaying==true)
            gameMusic.playLoop(); //Start music and play it on loop
        else
            gameMusic.stop(); //Stops the music
    }
    /**
     * spawnEnemies - Method used to spawn enemies if the condiction is true
     */
    public void spawnEnemies()
    {
        if(Greenfoot.getRandomNumber(750)<1) //1 in 750 chance (0 to 749)
        {
            // X between 50 and 1230 that can spwan trash
            addObject(new Enemy1(),Greenfoot.getRandomNumber(1131)+50,0); 
        }
    }
}
