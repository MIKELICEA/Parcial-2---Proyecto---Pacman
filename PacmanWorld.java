import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacmanWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{
    
    /**
     * Constructor for objects of class PacmanWorld.
     * 
     */
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 1150, 1); 
        construct();
    }
    
    private void construct()
   {       
       PacmanWall wall = new PacmanWall();
       Cherry cherry = new Cherry();
       Orange orange = new Orange();
       Strawberry strawberry = new Strawberry();
       
       addObject(cherry, 450, 500);
       addObject(strawberry, 100, 500);
       addObject(orange, 800, 500);
       
       for(int x = 30; x < 1050; x += 30)
       {
           wall = new PacmanWall();
           addObject(wall, x, 100);
           wall = new PacmanWall();
           addObject(wall, x, 900);
       }
       
       for(int y = 100; y < 700;y+=30)
        {
            wall = new PacmanWall();
            addObject(wall,200,y);
            wall = new PacmanWall();
            addObject(wall,700,y);
        }   
        
       PacmanHud hud = new PacmanHud();
       addObject(hud, 450, 575);
       
       Pacman pacman = new Pacman(hud);
       addObject(pacman,450,653);
       
   }
    
    
}
