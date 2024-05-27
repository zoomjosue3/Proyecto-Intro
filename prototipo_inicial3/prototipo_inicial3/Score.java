import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    private MyWorld world;
    
    public Score(MyWorld world) {
        this.world = world;
    }
    
    public void act() 
    {
        String text = "Level " + world.getLevel() + ", Score: " + world.getScore();
        
        GreenfootImage img = new GreenfootImage(text, 24, Color.GREEN, Color.BLACK);
        
        setImage(img);
    }    
}
