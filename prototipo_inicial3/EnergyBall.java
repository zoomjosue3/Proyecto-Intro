import greenfoot.*;  

public class EnergyBall extends Actor
{
    private static final int SPEED = 5; // Velocidad de la bola de energía

    public void act() 
    {
        move(SPEED);
        checkCollision();
    }    

    private void checkCollision() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
            return;
        }
        Actor papel = getOneIntersectingObject(Papel.class);
        if (papel != null) {
            ((MyWorld)getWorld()).removePapel((Papel)papel);
            getWorld().removeObject(this);
        }
    }
}
