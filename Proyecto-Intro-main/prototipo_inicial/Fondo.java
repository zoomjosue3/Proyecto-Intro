import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fondo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fondo extends World
{

    /**
     * Constructor for objects of class Fondo.
     * 
     */
    public Fondo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 800, 1); 
        Piedra piedra = new Piedra();
        addObject(piedra, getWidth() / 2, 650);

        prepare();
    }
    private void prepare()
    {
        Humano humano = new Humano();
        addObject(humano,387,0);
        Humano humano2 = new Humano();
        addObject(humano2,99,0);
        Humano humano3 = new Humano();
        addObject(humano3,162,0);
        Humano humano4 = new Humano();
        addObject(humano4,443,0);
        Humano humano5 = new Humano();
        addObject(humano5,524,0);
        Humano humano6 = new Humano();
        addObject(humano6,594,0);
        Humano humano7 = new Humano();
        addObject(humano7,708,0);
    }
}
