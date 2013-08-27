package sh.eran.ctu.IT251;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author eran
 */
public class Transaction {
    
    public static int totalObjects;
    
    private String ID, name, description;
    private int quantity;
    private double itemCost;
    private Date date;

    public Transaction(
            String name, 
            String description, 
            int quantity, 
            double itemCost) {
        
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.itemCost = itemCost;
       
       this.date = Calendar.getInstance().getTime();
       this.ID = String.valueOf( totalObjects++ );
        
    } // end constructor

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
    
    public double getTotal(){
        return quantity * itemCost;
    }
    
    public double getQuantity(){
        return this.quantity;
    }

}
