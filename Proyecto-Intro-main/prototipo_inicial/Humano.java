import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Humano extends Actor {
    public void act() {
        setLocation(getX(), getY()+1);
        eat();
        
        if(getY() >= getWorld().getHeight()-1){
            Fondo juego = (Fondo) getWorld();
            getWorld().removeObject(this);
        }
        
    }
    public void eat(){
        Actor piedra;
        piedra = getOneObjectAtOffset(0, 0, Piedra.class);
        if (piedra != null){
            World world;
            world = getWorld();
            world.removeObject(piedra);
            Greenfoot.stop();
        }
    }

}

