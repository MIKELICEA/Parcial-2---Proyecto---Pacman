import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int MAX_COUNTER_MOUTH = 10;
    private static final int MAX_COUNTER_MOVEMENT = 4;
    private static final int OFFSET = 10;
    
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int RIGHT = 2;
    private static final int LEFT = 3;
    
    private GreenfootImage []right;
    private GreenfootImage []left;
    private GreenfootImage []up;
    private GreenfootImage []down;
    
    private int currentImage;
    private int counterMouth;
    private int offsetX=0;
    private int offsetY=0;
    private int counterMovement;
    private int direction;
    private int score;
    private int lastButtomPress;
    private boolean standingStill;
    
    private PacmanHud pacmanhud;
    
    public Pacman(PacmanHud pacmanhud){
        right = new GreenfootImage[2];
        right[0]= new GreenfootImage("images/close-mouth.png");
        right[1]= new GreenfootImage("images/open-mouth-right.png");
     
        left = new GreenfootImage[2];
        left[0]= new GreenfootImage("images/close-mouth.png");
        left[1]= new GreenfootImage("images/open-mouth-left.png");
        
        up = new GreenfootImage[2];
        up[0]= new GreenfootImage("images/close-mouth.png");
        up[1]= new GreenfootImage("images/open-mouth-up.png");
        
        down = new GreenfootImage[2];
        down[0]= new GreenfootImage("images/close-mouth.png");
        down[1]= new GreenfootImage("images/open-mouth-down.png");
        this.pacmanhud=pacmanhud;
        
    }
    
    public void act()
    {
        // Add your action code here.
       GreenfootImage myImage = getImage();
       myImage.scale(50, 50);
           
        openCloseMouthRight();
        movePacman();
        checkPoints(); 
        //getWorld().showText(String.valueOf(score),400,30);
    }
    
    private void checkPoints(){
        Item item = (Item)getOneIntersectingObject(Item.class);
        
        if(item!=null){
            getWorld().removeObject(item);
            score+=item.getScore();
            pacmanhud.setScore(score);
            
            if(getWorld().getObjects(Item.class).isEmpty()){
                offsetX=0;
                offsetY=0;
                
                getWorld().showText("GAME OVER",450,575);
            }
        }
    }
    
    private void movePacman()
    {
        counterMovement++;
          
        if(counterMovement < MAX_COUNTER_MOVEMENT){
            return;
        }
        
        int currentX = getX();
        int currentY = getY();
        
        counterMovement=0;
        handleDirection();
        
        Actor wall = getWall();
        
        if(wall==null)
        {
            setLocation(currentX + offsetX, currentY+offsetY);
        }
    }
    
    private PacmanWall getWall(){
        Actor wall=null;
        
        switch(direction){
            case UP:
                return (PacmanWall) getOneObjectAtOffset(0,-5,PacmanWall.class);
            case DOWN:
                return (PacmanWall) getOneObjectAtOffset(0,5,PacmanWall.class);
            case RIGHT:
                return (PacmanWall) getOneObjectAtOffset(5,0,PacmanWall.class);
            case LEFT:
                return (PacmanWall) getOneObjectAtOffset(-5,0,PacmanWall.class);
        }
        
        return null;
        
    }
    
    private void handleDirection()
    {
        if(Greenfoot.isKeyDown("UP"))
        {
            offsetX=0;
            offsetY=-OFFSET;
            direction=UP;
            
            openCloseMouthUp();
            
        }else if(Greenfoot.isKeyDown("DOWN")){
            offsetX=0;
            offsetY=OFFSET;
            direction=DOWN;
            
            openCloseMouthDown();
            
        }else if(Greenfoot.isKeyDown("RIGHT"))
        {
            offsetY=0;
            offsetX=OFFSET;
            direction=RIGHT;
            
            openCloseMouthRight();
            
        }else if(Greenfoot.isKeyDown("LEFT")){
            offsetY=0;
            offsetX=-OFFSET;
            direction=LEFT;
            
            openCloseMouthLeft();
            
        }
        
    }
    
    
    private void openCloseMouthRight()
    {
        counterMouth++;
        if(counterMouth==MAX_COUNTER_MOUTH)
        {
            counterMouth=0;
            setImage(right[currentImage]);
            currentImage = (currentImage+1)%right.length;
        }
    }
    
    private void openCloseMouthLeft()
    {
        counterMouth++;
        if(counterMouth==MAX_COUNTER_MOUTH)
        {
            counterMouth=0;
            setImage(left[currentImage]);
            currentImage = (currentImage+1)%left.length;
        }
            
    }
    
    private void openCloseMouthUp()
    {
        counterMouth++;
        if(counterMouth==MAX_COUNTER_MOUTH)
        {
            counterMouth=0;
            setImage(up[currentImage]);
            currentImage = (currentImage+1)%up.length;
        }
    }
    
    private void openCloseMouthDown()
    {
        counterMouth++;
        if(counterMouth==MAX_COUNTER_MOUTH)
        {
            counterMouth=0;
            setImage(down[currentImage]);
            currentImage = (currentImage+1)%down.length;
        }
    }
}
