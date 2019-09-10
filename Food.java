/*  Name: Ethan Chen
 *  PennKey: etc
 *  Recitation: 217
 *
 *  Execution: java LinkedList
 * 
 *  Creates a SnakeSegment class stored as the generic object in the Node of 
 * the generic LinkedList class
 */

public class Food {
    private int value;
    private double x;
    private double y;
    private double radius;
    
    //constructor
    public Food(double radius) {
        value = 1;
        this.radius = radius;
        x = Math.max((Math.random() * 0.9) -  radius, radius + 0.1);
        y = Math.max((Math.random() * 0.9) - radius, radius + 0.1);
        PennDraw.filledCircle(x, y, radius);
    }
    
    //constructor
    public Food(int value, double radius) {
        this.value = value;
        this.radius = radius;
        x = Math.max((Math.random() * 0.9) -  radius, radius + 0.1);
        y = Math.max((Math.random() * 0.9) - radius, radius + 0.1);
        PennDraw.filledCircle(x, y, radius);
    }
    
    //getter for value
    public int getValue() {
        return value;
    }
    
    //getter for x
    public double getX() {
        return x;
    }
    
    //getter for y
    public double getY() {
        return y;
    }
    
    //getter for radius
    public double getRadius() {
        return radius;
    }
    
    //draw the Food
    public void draw() {
        PennDraw.circle(x, y, radius);
    }
    
    public static void main(String[] args) {
        while(true) {
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();
                Food poop = new Food(0.02);
            }
        }
    }
}