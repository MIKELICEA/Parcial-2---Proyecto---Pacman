import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacmanHud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanHud extends Actor
{
    private int score;
    private int level = 1;
    private int lifes = 3;
    
    public void setScore(int score){
        this.score=score;
    }
    
    public void act(){
        refresh();
    }
    
    public void refresh()
    {
        getWorld().showText("Level: "+level,200,30);
        getWorld().showText("Lifes: "+lifes,500,30);
        getWorld().showText("Score: "+score,700,30);
    }
}
