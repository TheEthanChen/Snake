/*  Name: Ethan Chen
 *  PennKey: etc
 *  Recitation: 217
 *
 *  Execution: java LinkedList
 * 
 * Creates a LinkedList called Snake containing Nodes containing SnakeSegments
 * using the generic LinkedList class
 */

public class Snake {
    private LinkedList<SnakeSegment> theSnake;
    
    //constructor
    public Snake() {
        theSnake = new LinkedList<SnakeSegment>();
    }
    
    //adds a Node with the SnakeSegment inputted at the end of the LinkedList
    public boolean add(SnakeSegment coil) {
        return theSnake.add(coil);
    }
    
    //adds a Node with the SnakeSegement inputted at the inputted index
    public boolean add(int index, SnakeSegment coil) {
        return theSnake.add(index, coil);
    }
    
    //removes a Node at the inputted index and returns its SnakeSegment
    public SnakeSegment remove(int index) {
        return theSnake.remove(index);
    }
    
    //returns a SnakeSegment at the inputted index
    public SnakeSegment get(int index) {
        return theSnake.get(index);
    }
    
    //replaces a SnakeSegment at the set index with the inputted SnakeSegment
    //and returns the replaced SnakeSegment
    public SnakeSegment set(int index, SnakeSegment coil) {
        return theSnake.set(index, coil);
    }
    
    //checks if the inputted SnakeSegment is in the Snake
    public boolean contains(SnakeSegment coil) {
        return theSnake.contains(coil);
    }
    
    //returns the index of the SnakeSegment inputted
    public int indexOf(SnakeSegment coil) {
        return theSnake.indexOf(coil);
    }
    
    //returns the size of the Snake
    public int size() {
        return theSnake.size();
    }
    
    //returns the last SnakeSegment in the Snake
    public SnakeSegment last() {
        return theSnake.get(size() - 1);
    }
    
    //returns the first SnakeSegment in the Snake
    public SnakeSegment first() {
        return theSnake.get(0);
    }
    
    //moves the Snake depending on the direction inputted
    public void move(String direction) {
        SnakeSegment end = first().copy();
        if(size() > 1) {
            remove(size() - 1);
        }
        end.setDirection(direction);
        end.move();
        add(0, end);
        draw();
    }
    
    //moves the Snake
    public void move() {
        SnakeSegment end = first().copy();
        if(size() > 1) {
            remove(size() - 1);
        }
        end.move();
        add(0, end);
        draw();
    }
    
    //draws the Snake
    public void draw() {
        theSnake.get(0).draw(true);
        PennDraw.setPenColor(PennDraw.GREEN);
        for(int i = 1; i < size(); i++) {
            theSnake.get(i).draw();
        }
    }
    
    
    public static void main(String[] args) {
        Snake snek = new Snake();
        SnakeSegment oily = new SnakeSegment(1, 0 ,0, 0.1);
        SnakeSegment rubber = new SnakeSegment(2, 0.3, 0.4, "UP", 0, 0, 
                                               0.1);
        SnakeSegment circle = new SnakeSegment(3, 0.8, 0.9, "UP", 0, 0, 
                                               0.1);
        System.out.println(oily.getElement());
        System.out.println(oily.getX());
        System.out.println(oily.getY());
        snek.add(oily);
        snek.add(rubber);
        snek.set(0, circle);
        System.out.println(snek.theSnake.get(0));
        System.out.println(snek.size());
        System.out.println(snek.indexOf(oily));
        System.out.println(snek.contains(rubber));
        System.out.println(snek.last());
    }
}