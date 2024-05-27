import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Piedra extends Actor
{
    private int x;
    private int y;
    
    public Piedra(World world) {
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        x = (worldWidth / 2) - (imageWidth / 2);
        y = worldHeight - (imageHeight / 2);
    }

    public void act() 
    {
        if (Greenfoot.isKeyDown("left")) {
            x -= 2;
        } else if (Greenfoot.isKeyDown("right")) {
            x += 2;
        } else if (Greenfoot.isKeyDown("up")) {
            y -= 2;
        } else if (Greenfoot.isKeyDown("down")) {
            y += 2;
        }
        setLocation(x, y);
        checkCollision();
    }    
    
    private void checkCollision() {
        Papel papel = (Papel) getOneIntersectingObject(Papel.class);
        if (papel != null) {
            Greenfoot.stop();
            if(isTouching(Papel.class))
                {Greenfoot.setWorld(new GameOver());
                }
        }
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
}
