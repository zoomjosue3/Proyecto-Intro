import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * El mundo principal
 */
public class MyWorld extends World
{
    private static final Random _rand = new Random(37L);
    Piedra piedra;
    List<Papel> papeles;
    List<Integer> xPositions;
    List<Integer> xHistory;
    long numPapelesAdded = 0L;
    int maxPapeles = 5;
    /**
     * El constructor de objetos en MyWorld
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        Greenfoot.setSpeed(65);
        
        xHistory = new ArrayList<>();
        xPositions = getXPositions();
        

        papeles = new ArrayList<>();
        Piedra piedra = new Piedra();
        addObject(piedra, getWidth() / 2, getHeight() / 2);

        
    
    }
    
    public void act() {
        super.act();
        if (papeles.size() < maxPapeles) {
            double p = _rand.nextDouble();
            double t = (numPapelesAdded < 5) ? 0.995d : 0.99d;
            if (p > t) {
                addRedCar();
            }
        }
    }
    
    private void addRedCar() {
        Papel papel = new Papel(getRandomXPosition());
        papeles.add(papel);
        addObject(papel, papel.getX(), papel.getY());
        numPapelesAdded += 1L;
        if (numPapelesAdded % 50 == 0) {
            maxPapeles += 1;
        }
    }
    
    public void removePapel(Papel papel) {
        papeles.remove(papel);
        removeObject(papel);
    }
    
    public long getScore() { return numPapelesAdded; }
    
    public int getLevel() { return maxPapeles - 5 + 1; }
    
    private int getRandomXPosition() {
        int numPositions = xPositions.size();
        int index = -1;
        while (true) {
            index = _rand.nextInt(numPositions);
            
            if (!xHistory.contains(index)) {
                xHistory.add(index);
                break;
            }
        }
        
        if (xHistory.size() > 5) {
            xHistory.remove(0);
        }
        
        return xPositions.get(index);
    }
    
    private List<Integer> getXPositions() {
        int carWidth = (new Papel()).getWidth();
        int gameWidth = getWidth();
        List<Integer> positions = new ArrayList<>();
        for (int i = 5; i < gameWidth; i += carWidth) {
            positions.add(i);
        }
        return positions;
    }
}
