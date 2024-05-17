import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Humano extends Actor {
    public void act() {
        if (isTouching(Piedra.class)) {
            Piedra piedra = (Piedra) getOneIntersectingObject(Piedra.class);
            getWorld().removeObject(piedra);
        }
    }
}

