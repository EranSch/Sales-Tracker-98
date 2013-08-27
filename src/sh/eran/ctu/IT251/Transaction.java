package sh.eran.ctu.IT251;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author eran
 */
public class Transaction {
    
    /*
     * ======================= STATIC CLASS VARIABLES ==========================
     */  
    
    /*
     * Like anything else, we will need to track how many instances are floating
     * around so we can assign the correct ID to each one.
     */
    
    public static int totalObjects;
    
    
    /*
     * ========================= INSTANCE VARIABLES ===========================
     */    
    
    /*
     * Because this object has been designed primarily to just hold information
     * of varying types, this is really the bread and butter. 
     */
    
    private String ID, name, description;
    private double quantity;
    private double itemCost;
    private Date date;

    
    /*
     * ======================== CONSTRUCTOR METHODS ============================
     */
    
    /*
     * This object also needs some special considerations to make sure new entries
     * get recorded correctly. Specifically, each object should be instantiated 
     * with a unique ID and the date at which it was created.
     */
    
    public Transaction(
            String name, 
            String description, 
            double quantity, 
            double itemCost
            ) {
        
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.itemCost = itemCost;
       
       this.date = Calendar.getInstance().getTime();
       this.ID = String.valueOf( totalObjects++ );
        
    }
    
    
    
    /*
     * ========================= toString() METHOD =============================
     */
    
    /*
     * Because of all the emphasis on toString overriding in this assignment, it 
     * seemed proper to give this class the same treatment. 
     */

    @Override
    public String toString() {
        
        StringBuilder response = new StringBuilder();
        
        response.append("\n    ").append("Transaction ID: ").append( ID );
        response.append("\n    ").append("Name: ").append( name );
        response.append("\n    ").append("Date: ").append( date );
        response.append("\n    ").append("Description: ").append( description );
        response.append("\n    ").append("Quantity: ").append( quantity );
        response.append("\n    ").append("Item Cost: ").append( itemCost );
        response.append("\n    ").append("Total Cost: ").append( this.getTotal() );
        response.append("\n    ");
        
        return response.toString();
        
    } // end method
    
    
    /*
     * ======================== BASIC GETTERS/SETTERS ==========================
     */    
    
    public double getTotal(){
        return quantity * itemCost;
    }
    
    public double getQuantity(){
        return this.quantity;
    }

}
