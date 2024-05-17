import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends World
{

    /**
     * Constructor for objects of class Play.
     * 
     */
    public Play()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        Piedra piedra = new Piedra();
        addObject(piedra, getWidth() / 2, getHeight() / 2);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Humano humano = new Humano();
        addObject(humano,387,129);
        Humano humano2 = new Humano();
        addObject(humano2,99,184);
        Humano humano3 = new Humano();
        addObject(humano3,162,426);
        Humano humano4 = new Humano();
        addObject(humano4,387,520);
        Humano humano5 = new Humano();
        addObject(humano5,581,401);
        Humano humano6 = new Humano();
        addObject(humano6,594,183);
        Humano humano7 = new Humano();
        addObject(humano7,708,303);
    }
}
