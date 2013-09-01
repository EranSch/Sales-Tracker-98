package sh.eran.ctu.IT251;
import java.util.Scanner;

/**
 * 
 * @author eran
 * @version 1.2
 * 
 * This class was developed to remove some of the mundane tasks involved in
 * communicating with the user. Expect to see simplifications in terms of
 * writing to the console as well as means of getting responses from the user
 * The goal here is to continually build on this class and wind up with 
 * a solid tool by the end of my degree. 
 */

public class IO {
    
    /*
     * ============================= IO.print ==================================
     */ 
    
    /*
     * I got sick of typing "System.out.println()" all the time. I think this was 
     * the main reason I started this class. Ahhh, I love this stuff!
     * 
     * Give it a string and watch is print on the console-- Magic!
     * 
     */
    
    public static void print( String message ){
        System.out.println( message );
    }
    
    
    /*
     * =========================== IO.clearConsole =============================
     */ 
    
    /*
     * Another mundane task, So strange there isn't something in API for this...
     * All this does is clears the console for pretty navigation. Also magic.
     * 
     */    
    
    public static void clearConsole(){
        
        for( int i=0; i < 1000; i++ ){
            IO.print("\n");
        }
        
    }

    
    /*
     * =============================== IO.getInt ===============================
     */ 
    
    /*
     * This is a little more interesting, the method takes two arguments-- A 
     * string and an integer. While this could be used for other tasks, the 
     * original implemnetaion was for handling user response in terms of an 
     * indexed menu. The idea being; print the menu, and wait for the user to
     * pick an option. The first arguement, String, is the message you'd like to
     * pass to user (e.g. "Please select an item from the item" ). The following 
     * argument sets the ceiling of the range of numbers available for selection.
     * 
     * @returns int
     * 
     */    
    
    public static int getInt( String message, int ceiling ) {
        
        Scanner sc = new Scanner(System.in);
        int userInteger;
        
        do // This loop will enforce the input falls within the defined range...
        {
            
            // Print the messages
            IO.print(message);
            IO.print( "Enter a number (1 - " + ceiling + ")");
            
            // This inner loop will also encorce the input be an Integer.
            while( !sc.hasNextInt() )
            {
                IO.print( "Enter a NUMBER between 1 and " + ceiling + "." );
                sc.next();
            }
            
            userInteger = sc.nextInt();
        
        } while ( userInteger < 1 || userInteger > ceiling );
        
        return userInteger;
        
    }
    

    /*
     * ============================= IO.getConfirm =============================
     */ 
    
    /*
     * If you thought that was fun, check this method out! This also takes a 
     * String message as the input however it returns a boolean. This assumes
     * you're posing a y/n type of question to the user.
     * 
     * @returns boolean
     * 
     */    

    public static boolean getConfirm( String message ) {
        
        String userReply; // Going to store the response here for evaluation
        Scanner sc = new Scanner(System.in);
        
        do // Loop to enforce proper y/n response from user. 
        {
            IO.print( message );
            IO.print( "Please enter 'y' or 'n'" ); 
            userReply = sc.nextLine().toLowerCase(); 
        }
        while( !userReply.equals("y") && !userReply.equals("n") );
        
        return userReply.equals("y");
        
    } // end method
    
    /*
     * ============================= IO.printMenu =============================
     */ 
    
    /*
     * Attempting to devise a clean means of handling text-based menus. This is 
     * the latest-- Pass an array with each menu option and a message to be 
     * displayed to the user and this will retrun an integer corresponding to 
     * the value selected by the user.
     * 
     * NOTE: While this will display the index numbers in one-base (1 , 2, 3 [...]) 
     * it will return a value in zero-base (0, 1, 2, [...]). My theory is that 
     * the user should never see zero-base numerals however they should be used
     * when appropriate on the backend :)
     * 
     */
    
    public static int printMenu( String[] labels, String message ){

        for( int i=0; i < labels.length; i++  ){
            
            IO.print( "[" + ( i + 1 ) + "] "+ labels[i] );
            
        }
        
        return ( IO.getInt( message, labels.length ) - 1 );
        
    }
    
}
