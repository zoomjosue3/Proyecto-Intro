import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        super(800, 600, 1);
        Button playButton = new Button("jugar8.png", new MyWorld());
        addObject(playButton, 150, 350);
        
    }
}

