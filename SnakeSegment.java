/*  Name: Ethan Chen
 *  PennKey: etc
 *  Recitation: 217
 *
 *  Execution: java LinkedList
 * 
 *  Creates a SnakeSegment class stored as the generic object in the Node of 
 * the generic LinkedList class
 */


public class SnakeSegment {
    private int element;
    private double x;
    private double y;
    private double radius;
    private double vx;
    private double vy;
    private String direction;
    private int counter;
    
    //constructor
    public SnakeSegment(int element, double vx, double vy, double radius) {
        this.element = element;
        x = 256.0 / 512.0;
        y = x;     
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
        direction = "LEFT";
        PennDraw.filledCircle(x, y, radius);
    }
    
    //constructor
    public SnakeSegment(int element, double x, double y, String direction, 
                        double vx, double vy, double radius) {
        this.element = element;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
        this.direction = direction;
        PennDraw.circle(x, y, radius);
    }
    
    //getter for element
    public int getElement() {
        return element;
    }
    
    //getter for x
    public double getX() {
        return x;
    }
    
    //getter for y
    public double getY() {
        return y;
    }
    
    //getter for vx
    public double getVx() {
        return vx;
    }
    
    //gettter for vy
    public double getVy() {
        return vy;
    }
    
    //getter for radius
    public double getRadius() {
        return radius;
    }
    
    //getter for direction
    public String getDirection() {
        return direction;
    }
    
    //creates a copy of the SnakeSegment
    public SnakeSegment copy() {
        SnakeSegment copy = new SnakeSegment(1, getX(), getY(), 
                                                    getDirection(),
                                                    getVx(), getVy(), 
                                                    getRadius());
        return copy;
    }
    
    //moves the SnakeSegment a certain direction depending on its direction
    //value
    public void move() {
        if(direction.equals("LEFT")) {
            this.x -= this.vx;
        }
        else if(direction.equals("RIGHT")) {
            this.x += this.vx;
        }
        else if(direction.equals("UP")){
            this.y += this.vy;
        }
        else {
            this.y -= this.vy;
        }
    }
    
    //draws the SnakeSegment
    public void draw() {
        PennDraw.filledCircle(x, y, radius);
    }
    
    //draw face for Snake
    public void draw(boolean head) {
        PennDraw.filledCircle(x, y, radius);
        PennDraw.setPenColor(255, 0, 20);
        PennDraw.filledCircle(x - 0.5 * radius, y + 0.5 * radius, radius / 10);
        PennDraw.filledCircle(x + 0.5 * radius, y + 0.5 * radius, radius / 10);
        PennDraw.filledEllipse(x, y - 0.5 * radius, radius / 2, radius / 5);
        PennDraw.setPenColor(200, 75, 40);
        PennDraw.filledPolygon(x - 0.3 * radius, y - 0.5 * radius, 
                               x - 0.3 * radius, y - 2 * radius, 
                               x + 0.1 * radius, y - 0.5 * radius);
        PennDraw.filledPolygon(x + 0.4 * radius,  y - 0.5 * radius, 
                               x + 0.2 * radius, y - 2 * radius, 
                               x + 0.1 * radius, y - 0.5 * radius);
    }
    
    //setter for x
    public void setX(double x) {
        this.x = x;
    }
    
    //setter for y
    public void setY(double Y) {
        this.y = y;
    }
    
    //setter for Direction
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    
    public static void main(String[] args) {
        SnakeSegment head = new SnakeSegment(1, 0.5, 0.5, "LEFT", 0.1, 0.1, 
                                             0.1);
        head.counter = 4;
        head.draw(true);
    }
}