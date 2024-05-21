import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MyWorld extends World
{
    private static final Random rand = new Random(37L);
    Piedra piedra;
    List<Papel> papeles;
    List<Integer> xPositions;
    long numPapelesAdded = 0L;
    int maxPapeles = 5;

    public MyWorld()
    {    
        super(1100, 600, 1);  

        setBackground("885542.jpg"); 

        Greenfoot.setSpeed(65);
        
        xPositions = getXPositions();
        
        piedra = new Piedra(this);
        papeles = new ArrayList<>();
        
        addObject(piedra, piedra.getX(), piedra.getY());
        addObject(new Score(this), 85, 10);
        addPapel();
    }
    
    public void act() {
        if (papeles.size() < maxPapeles) {
            if (rand.nextDouble() > 0.99) {
                addPapel();
            }
        }
    }
    
    private void addPapel() {
        int level = getLevel();
        int speed = 1 + level; 
        Papel papel = new Papel(getRandomXPosition(), speed);
        papeles.add(papel);
        addObject(papel, papel.getX(), papel.getY());
        numPapelesAdded += 1;
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
        return xPositions.get(rand.nextInt(numPositions));
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
