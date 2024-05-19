import greenfoot.*;

public class Piedra extends Actor {
    public void act() {
        // Actualiza la posición de la piedra según las teclas presionadas
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 1, getY());
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 1, getY());
        } else if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 1);
        } else if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 1);
        }
    }
}