import greenfoot.*;

/**
 * Codigo de la 'Piedra'
 * Version 4
 */

public class Piedra extends Actor 
{
    private int x;
    private int y;
    
    public Piedra(World world) {
        int wWidth = world.getWidth();
        int wHeight = world.getHeight();
        int iWidth = getImage().getWidth();
        int iHeight = getImage().getHeight();
        
        x = (wWidth / 2) - (iWidth / 2);
        y = wHeight - (iHeight / 2);
    }
    /**
     * La funcion 'Act' para que se mueva la piedra a donde quiera
     * cuando se presione 'Run' o 'Act'
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left")) {
            x = x - 1;
        } else if (Greenfoot.isKeyDown("right")) {
            x = x + 1;
        } else if (Greenfoot.isKeyDown("up")) {
            y = y - 1;
        } else if (Greenfoot.isKeyDown("down")) {
            y = y + 1;
        }
        setLocation(x, y);
        checkCollision();
    }    
    
    public void checkCollision() {
        Papel papel = (Papel) getOneIntersectingObject(Papel.class);
        if (null != papel) {
            Greenfoot.stop();
        }
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
}