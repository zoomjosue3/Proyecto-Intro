import greenfoot.*;  // Importa todas las clases necesarias de la biblioteca Greenfoot
import java.util.List;  // Importa la interfaz List de la biblioteca de utilidades de Java
import java.util.ArrayList;  // Importa la clase ArrayList de la biblioteca de utilidades de Java
import java.util.Random;  // Importa la clase Random para generar números aleatorios

/**
 * Write a description of class MyWorld here.
 * 
 * (Escribe una descripción de la clase MyWorld aquí)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    // Crea un objeto Random con una semilla fija para generar números aleatorios
    private static final Random _rand = new Random(37L);
    // Declara una variable para el objeto Piedra
    Piedra piedra;
    // Declara una lista para almacenar objetos Papel
    List<Papel> papeles;
    // Declara una lista para almacenar posiciones en X disponibles
    List<Integer> xPositions;
    // Declara una lista para mantener un historial de las últimas posiciones en X usadas
    List<Integer> xHistory;
    // Declara una variable para llevar la cuenta del número de Papeles añadidos
    long numPapelesAdded = 0L;
    // Declara una variable para el número máximo de Papeles permitidos en la pantalla
    int maxPapeles = 5;

    /**
     * Constructor for objects of class MyWorld.
     * 
     * (Constructor para objetos de la clase MyWorld)
     */
    public MyWorld() {    
        // Crea un nuevo mundo con 600x600 celdas y una celda de tamaño 1x1 píxeles
        super(600, 600, 1); 
        // Establece la velocidad de Greenfoot a 65
        Greenfoot.setSpeed(65);
        
        // Inicializa la lista de historial de posiciones en X
        xHistory = new ArrayList<>();
        // Obtiene las posiciones en X válidas y las guarda en xPositions
        xPositions = getXPositions();
        
        // Crea un objeto Piedra y lo asigna a la variable piedra
        piedra = new Piedra(this);
        // Inicializa la lista de Papeles
        papeles = new ArrayList<>();
        
        // Añade el objeto piedra al mundo en su posición inicial
        addObject(piedra, piedra.getX(), piedra.getY());
        // Añade un primer Papel al mundo
        addPapel();
    }
    
    // Método que se ejecuta en cada ciclo del juego
    public void act() {
        super.act();
        // Si el número de Papeles es menor que el máximo permitido
        if (papeles.size() < maxPapeles) {
            // Genera un número aleatorio entre 0 y 1
            double p = _rand.nextDouble();
            // Define el umbral de probabilidad basado en el número de Papeles añadidos
            double t = (numPapelesAdded < 5) ? 0.995d : 0.99d;
            // Si el número aleatorio es mayor que el umbral
            if (p > t) {
                // Añade un nuevo Papel
                addPapel();
            }
        }
    }
    
    // Método para añadir un nuevo Papel al mundo
    private void addPapel() {
        // Crea un nuevo Papel en una posición X aleatoria
        Papel papel = new Papel(getRandomXPosition());
        // Añade el Papel a la lista de papeles
        papeles.add(papel);
        // Añade el objeto papel al mundo en su posición inicial
        addObject(papel, papel.getX(), papel.getY());
        // Incrementa el contador de Papeles añadidos
        numPapelesAdded += 1L;
        // Cada 50 Papeles añadidos, incrementa el máximo de Papeles permitidos
        if (numPapelesAdded % 50 == 0) {
            maxPapeles += 1;
        }
    }
    
    // Método para eliminar un Papel del mundo
    public void removePapel(Papel papel) {
        // Remueve el Papel de la lista de papeles
        papeles.remove(papel);
        // Remueve el objeto papel del mundo
        removeObject(papel);
    }
    
    // Método para obtener la puntuación (el número de Papeles añadidos)
    public long getScore() { return numPapelesAdded; }
    
    // Método para obtener el nivel actual del juego
    public int getLevel() { return maxPapeles - 5 + 1; }
    
    // Método para obtener una posición X aleatoria que no haya sido usada recientemente
    private int getRandomXPosition() {
        int numPositions = xPositions.size();
        int index = -1;
        while (true) {
            // Selecciona un índice aleatorio de la lista de posiciones X
            index = _rand.nextInt(numPositions);
            
            // Si el índice no está en el historial reciente
            if (!xHistory.contains(index)) {
                // Añade el índice al historial
                xHistory.add(index);
                break;
            }
        }
        
        // Si el historial es mayor de 5, elimina el primer elemento
        if (xHistory.size() > 5) {
            xHistory.remove(0);
        }
        
        // Devuelve la posición X correspondiente al índice seleccionado
        return xPositions.get(index);
    }
    
    // Método para obtener una lista de posiciones X válidas
    private List<Integer> getXPositions() {
        // Obtiene el ancho de un Papel
        int papelWidth = (new Papel()).getWidth();
        // Obtiene el ancho del mundo
        int gameWidth = getWidth();
        // Crea una lista para las posiciones
        List<Integer> positions = new ArrayList<>();
        // Añade posiciones a la lista, separadas por el ancho del Papel
        for (int i = 5; i < gameWidth; i += papelWidth) {
            positions.add(i);
        }
        // Devuelve la lista de posiciones
        return positions;
    }
}
