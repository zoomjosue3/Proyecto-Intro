import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Papel extends Actor
{
    private static final Random rand = new Random(37L);
    
    private int x;
    private int y;
    private int speed; // Variable para la velocidad de caída
    
    public Papel() {
        this(0, 1);
    }
    
    public Papel(int x) {
        this(x, 1);
    }
    
    public Papel(int x, int speed) {
        this.x = x;
        this.y = getImage().getHeight() / 2;
        this.speed = speed;
    }
    
    public Papel(World world, int speed) {
        int wWidth = world.getWidth();
        int iHeight = getImage().getHeight();
        
        this.x = rand.nextInt(wWidth);
        this.y = iHeight / 2;
        this.speed = speed;
    }

    public void act() 
    {
        y += speed; // Usar la velocidad para mover el objeto
        setLocation(x, y);
        if (isAtEdge()) {
            ((MyWorld)getWorld()).removePapel(this);
        }
    }    
    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return getImage().getWidth(); }
    public int getHeight() { return getImage().getHeight(); }
}
