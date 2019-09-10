/*  Name: Ethan Chen
 *  PennKey: etc
 *  Recitation: 217
 *
 *  Execution: java LinkedList
 * 
 *  Creates a SnakeSegment class stored as the generic object in the Node of 
 * the generic LinkedList class
 */

public class SnakeGame {
    private int score;
    private int lives;
    private int[] highScores;
    private int foodNum;
    public boolean gameStart;
    private double vx;
    private double vy;
    private double headX;
    private double headY;
    private double headRadius;
    
    public static void main(String[] args) {
        //milliseconds between frames
        int millisBetweenFrames = 500;
        PennDraw.enableAnimation(60);
        
        //initializes a new SnakeGame and sets the important values
        SnakeGame theGame = new SnakeGame();
        theGame.score = 0;
        theGame.lives = 1;
        theGame.foodNum = 1;
        theGame.vx = 0.1;
        theGame.vy = 0.1;
        
        //Writes Menu
        PennDraw.clear(0, 0, 0);
        PennDraw.setPenColor(255, 0, 20);
        PennDraw.setFont("Hight Tower Text", 100);
        PennDraw.text(0.46, 0.6, "SNEK");
        PennDraw.setFont("Times New Roman", 30);
        PennDraw.text(0.49, 0.4, "Click Enter to Continue...");
        PennDraw.filledRectangle(0.47, 0.2, 0.3, 0.1);
        PennDraw.setFont("AR BERKLEY", 50);
        PennDraw.setPenColor(100, 0, 255);
        PennDraw.text(0.45, 0.2, "ENTER");
        PennDraw.advance();
        
        while (true) {
            //pauses for a fraction of a second
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            //start game if click inside the box
            if (PennDraw.mouseX() > 0.17 && PennDraw.mouseX() < 0.77 && 
                PennDraw.mouseY() > 0.1 && PennDraw.mouseY() < 0.4) {
                PennDraw.rectangle(0.47, 0.2, 0.3, 0.1);
                if(PennDraw.mousePressed()) {
                    PennDraw.advance();
                    break;
                }
            }
            //continue to draw the box
            else {
                PennDraw.setPenColor(255, 0, 30);
                PennDraw.filledRectangle(0.47, 0.2, 0.3, 0.1);
                PennDraw.setFont("AR BERKLEY", 50);
                PennDraw.setPenColor(100, 0, 255);
                PennDraw.text(0.45, 0.2, "ENTER");
                PennDraw.advance();
            }
        }
        PennDraw.enableAnimation(60);
        //Creates a new snake and adds the first segment to it
        Snake snek = new Snake();
        SnakeSegment original = new SnakeSegment(0, theGame.vx, 
                                                 theGame.vy, 0.05);
        snek.add(original);
        
        //creates the first piece of food
        Food yummy = new Food(0.02);
        
        //stores system time
        long lastTime = System.currentTimeMillis();
        
        //ony start the game if user has clicked the box
        while (theGame.lives > 0) {
            //pause game so it doesn't move too fast for user
            while (lastTime + millisBetweenFrames > 
                   System.currentTimeMillis()) {}
            lastTime = System.currentTimeMillis();
            
            // check if the user has typed a key; if so, process it   
            if (PennDraw.hasNextKeyTyped()) {
                
                //save key pressed
                char key = PennDraw.nextKeyTyped();
                
                //move Snake depending on the key pressed
                if(key == 'w') {
                    snek.move("UP");
                }
                else if(key == 'a') {
                    snek.move("LEFT");
                }
                else if(key == 's') {
                    snek.move("DOWN");
                }
                else if (key == 'd') {
                    snek.move("RIGHT");
                }
                //clears key typed so there is no backlog
                while (PennDraw.hasNextKeyTyped()) {
                    PennDraw.nextKeyTyped();          
                }
            }
            
            //if no key pressed, keep moving forward in previous direction
            else {
                snek.move();
            }
            
            //if the food is touches the head of the snake, eat it and
            //add a SnakeSegment to the Snake
            if (theGame.distance(yummy.getX(), yummy.getY()) < 
                theGame.contact(yummy.getRadius())) {
                SnakeSegment newSegment = 
                    new SnakeSegment(1, snek.last().getX() + 0.005, 
                                     snek.last().getY() + 0.005, 
                                     snek.last().getDirection(), 
                                     theGame.vx, theGame.vy, 0.03);
                snek.add(newSegment);
                
                //remove the food
                yummy = null;
                theGame.foodNum--;
                
                //add score
                theGame.score++;
            }
            
            //animatiomn
            PennDraw.clear();
            theGame.headX = snek.first().getX();
            theGame.headY = snek.first().getY();
            theGame.headRadius = snek.first().getRadius();
            
            //draw the snake
            snek.draw();
            
            //if the food has been eaten, create another one!
            if (theGame.foodNum < 1) {
                yummy = new Food(0.02);
                yummy.draw();
                theGame.foodNum++;
            }
            
            //if the food has not been eaten, draw it!
            if (yummy != null) {
                yummy.draw();
            }
            
            
            //check if the head touches any other parts of its body (besides
            //the one right behind it)
            for (int i = 2; i < snek.size(); i++) {
                System.out.println(theGame.distance(snek.get(i).getX(), 
                                     snek.get(i).getY()));
                System.out.println(theGame.contact(snek.get(i).getRadius()));
                if (theGame.distance(snek.get(i).getX(), 
                                     snek.get(i).getY()) < 
                    theGame.contact(snek.get(i).getRadius()) - 0.01) {
                    theGame.lives--;
                    break;
                }
            }
            
            //check if the Snake hits the side and dies
            if (theGame.headX > 1 || theGame.headX < 0 || theGame.headY < 0 || 
                theGame.headY > 1) {
                theGame.lives--;
                break;
            }
            PennDraw.advance();
        }
        
        //store the high score
        theGame.score = snek.size();
        
        //draw score board
        theGame.highScore(theGame.score);
        
        //draw play again
        PennDraw.setPenColor(255, 0, 20);
        PennDraw.filledRectangle(0.47, 0.18, 0.4, 0.08);
        PennDraw.setFont("AR BERKLEY", 40);
        PennDraw.setPenColor(100, 0, 255);
        PennDraw.text(0.47, 0.2, "START AGAIN?"); 
        
        //wait 3 seconds before advancing
        try {
            Thread.sleep(3000);     
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        PennDraw.advance();
        
        //allows highlighting of the box when mouse over it
        while (true) {
            try {
                Thread.sleep(100);    
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (PennDraw.mouseX() > 0.07 && PennDraw.mouseX() < 0.87 && 
                PennDraw.mouseY() > 0.1 && PennDraw.mouseY() < 0.26) {
                PennDraw.rectangle(0.47, 0.18, 0.4, 0.08);
                if(PennDraw.mousePressed()) {
                    PennDraw.advance();
                    main(null);
                    break;
                }
            }
            else {
                PennDraw.setPenColor(255, 0, 20);
                PennDraw.filledRectangle(0.47, 0.18, 0.4, 0.08);
                PennDraw.setFont("AR BERKLEY", 40);
                PennDraw.setPenColor(100, 0, 255);
                PennDraw.text(0.47, 0.2, "START AGAIN?"); 
            }
            PennDraw.advance();
        }
    }
    
    //calculates the distance from an item to the head of the Snake
    public double distance(double itemX, double itemY) {
        return Math.sqrt(Math.pow((itemX - headX), 2) + 
                         Math.pow((itemY - headY), 2));
    }
    
    //check if an item has touched the head of the Snake
    public double contact(double itemRadius) {
        return (itemRadius + headRadius);
    }
    
    public void highScore(int score) {
        //creates new high score if none currently
        if (highScores == null) {
            highScores = new int[10];
            highScores[0] = score;
        }
        //adds highest score to top of list
        else {
            for (int i = 0; i < highScores.length; i++) {
                if (score > highScores[i]) {
                    for (int j = i; j < highScores.length - 1; j++) {
                        highScores[j + 1] = highScores[j];
                    }
                    highScores[i] = score;
                    break;
                }
            }
        }
        
        //graphics to see high scores
        PennDraw.clear(0, 0, 0);
        PennDraw.setPenColor(255, 10, 50);
        PennDraw.setFont("Cambria", 20);
        PennDraw.text(0.47, 0.95, "HIGH SCORES");
        for (int i = 0; i < highScores.length; i++) {
            PennDraw.text(0.47, 0.9 - i * 0.05, i + ". " + highScores[i]);
        }   
    }
}