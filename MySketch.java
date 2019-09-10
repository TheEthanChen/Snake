/**
 * Name : Ethan Chen
 * PennKey : etc
 * Recitation: ???
 * 
 * Execution: java MySketch
 * 
 * A drawing of my own creation
 * 
 */

public class MySketch {
    public static void main(String [] args) {
    
        PennDraw.setCanvasSize(600, 600); 
        PennDraw.clear(PennDraw.BLUE);
        
       //Neck
       PennDraw.setPenColor(1, 255, 50);
       PennDraw.filledSquare(.5, .5, .33, 45);
       PennDraw.setPenColor(255, 20, 0);
       PennDraw.filledCircle(.5, .5, .33);
       
       //Elongated Neck
       PennDraw.setPenColor(255, 30, 30);
       //PennDraw.
       
        
        //Head
        PennDraw.setPenColor(1, 250, 1); 
        PennDraw.filledPolygon(0.10, 0.50, 0.50, 0.90, 0.90, 0.50); 
        PennDraw.filledPolygon(.1, .5, .5, .1, .9, .5);
        
        //Mouth
        PennDraw.setPenColor(200, 50, 20);
        PennDraw.filledPolygon(0.15, 0.50, 0.5, 0.85, 0.85, 0.5); 
        PennDraw.filledPolygon(.15, .50, .5, .15, .85, .5);
        
        //Lines in Mouth
        PennDraw.setPenColor(0, 0, 0);
        PennDraw.setPenRadius(0.005);
        PennDraw.line(.15, .5, .85, .5);
        PennDraw.arc(0.5, .45, .28, 10, 170);
        PennDraw.arc(0.5, .40, .28, 20, 160);
        PennDraw.arc(0.5, .36, .28, 30, 150);
        PennDraw.arc(0.5, 0.32, 0.28, 40, 140);
        PennDraw.arc(0.5, 0.29, 0.28, 50, 130);
        PennDraw.arc(0.5, 0.26, 0.28, 60, 120);
        PennDraw.arc(0.5, 0.24, 0.28, 70, 110);
        PennDraw.arc(0.5, 0.23, .28, 80, 100);
        
        //Tongue
        PennDraw.setPenColor(200, 75, 40);
        PennDraw.filledArc(0.50, 0.5, 0.09, 0, 180);
        
        
        //Big Teeth
        PennDraw.setPenColor(255, 255, 255);
        PennDraw.filledPolygon(0.38, 0.73, 0.48, 0.83, 0.45, 0.6);
        PennDraw.filledPolygon(0.52, 0.83, 0.62, 0.73, 0.55, 0.6);
        
        //Whites of the eyes
        PennDraw.filledEllipse(0.3, 0.78, 0.07, 0.03, 90);
        PennDraw.filledEllipse(0.7, 0.78, 0.07, 0.03, 90);
        
        // First Teeth Portion
        PennDraw.filledPolygon(0.27, 0.62, 0.33, 0.68, .38, .55);
        PennDraw.filledPolygon(0.31, 0.62, 0.38, 0.55, 0.33, 0.45);
        
        //Second Teeth Portion
        PennDraw.filledPolygon(.73, 0.62, 0.670, 0.68, 0.62, 0.55);
        PennDraw.filledPolygon(0.69, 0.62, 0.62, 0.55, 0.67, 0.45);
        
        //Red Eyes
        PennDraw.setPenColor(255, 0, 50);
        PennDraw.filledEllipse(0.3, 0.78, 0.06, 0.02, 90);
        PennDraw.filledEllipse(0.7, 0.78, 0.06, 0.02, 90);
        
        //Forked Tongue
        PennDraw.setPenColor(200, 75, 40);
        PennDraw.filledPolygon(0.41, 0.5, 0.5, 0.5, 0.5, 0.40, 0.42, 0.30);
        PennDraw.filledPolygon(0.5, 0.5, 0.59, 0.5, 0.58, 0.3, 0.5, 0.4);
        
        
        
    }
}