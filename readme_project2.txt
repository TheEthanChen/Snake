/**********************************************************************
 *  project2.txt template                                                   
 *  Project Part 2
 **********************************************************************/

PARTNER 1 (whose PennKey would come first in alphabetical order)
Partner 1 Name: Ethan Chen
Partner 1 PennKey:etc
Partner 1 Recitation #: 217

PARTNER 2 (whose PennKey would come second in alphabetical order)
(If you chose to do this project without a partner, write NONE in each spot below.)
Partner 2 Name:
Partner 2 PennKey:
Partner 2 Recitation #:


/**********************************************************************
 * Description of Project: Write a detailed description of your project,
 * describing how you *actually* implemented it.  Be sure to cover:
 * - overview (provide a high level overview of your project and its functionality)
 * - object-oriented design (how did you incorporate techniques we discussed in class 
          on proper object-oriented design, including class decomposition, how classes
          interacted, etc?)
 * - techniques (describe any algorithms/techniques you used in your project)
 * - efficiency (how is your implementation computationally efficient?)
 * - expandability (how does your design/implementation allow the program to be 
                    easily extended with new functionality in the future?)
 * - challenges (what parts of your project were especially challenging?)
 * - open problems (are there any open issues with your project?)
 * The overall length of this description should be approximately 1 page
 * of single-spaced text.
 **********************************************************************/
My Snake game consists of en evergrowing Snake that will continue to grow as
    long as you continue to eat the green food pellets and don't hit yourself
    or any of the walls.It allows you to play again and stores the top 10
    highest scores.
    The Snake is an implementation of a generic LinkedList class with Nodes 
    containing the class SnakeSegment.
    It utilizes proper object-oriented design as I use multiple objects, from 
    the Food class, to the Snake class, to the SnakeSegment class, to implement
    my game. There are classes within classes, as in my generic LinkedList
    class with the Node class inside. And then I also place my SnakeSegment 
    class within the Node class within the LinkedList class called Snake. All
    these objects are run in the class SnakeGame. 
    I used some techniques I have learned throughout the course, such as how to
    compare to have the highest score first and how to point correctly.
    One can expand my program with additional functionality if one merely
    alters some of the variables(vx, vy, element, etc) for additional speed,
    colors, and points (if one adds up elements instead of size).
    The parts of my game that were especially challenging included getting
    the graphical elements of my game to match up with what is happening within
    the game.
    There should not be any issues with my project(though I wish the graphics
                                                       of the game were a bit
                                                       better).
    
                                                                           
                                                                        



/**********************************************************************
 *  Instructions for Running Your Project: 
 *  Provide DETAILED step-by-step instructions for running your project 
 *  and any notes on what the TAs should pay particular attention to when 
 *  grading.  If they can't run your project or didn't notice a particularly 
 *  cool aspect of it because you didn't provide thorough enough instructions, 
 *  then you won't receive credit for it.  It is your responsibility to make 
 *  sure these instructions are thorough and correct. 
 **********************************************************************/
1) Click the button "Enter" with your mouse to begin the game
2) Manuever the Snake using the WASD keys to eat the green blobs
3) Try to eat as many blobs as possible and grow without hitting yourself or
    the walls
4) You are allowed to hit the segment right behind you
5) Click the box "Play Again?" if you wish to play again
6) GO for the highest Score!



/**********************************************************************
 *  How precisely did your project use the LinkedList you implemented?
 **********************************************************************/
Created a Snake that was a LinkedList that grew as it ate stuff



/**********************************************************************
 *  List whatever help (if any) that you received
 **********************************************************************/
Some help from some CIS 120 Students





/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Adding graphically



/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the project, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
