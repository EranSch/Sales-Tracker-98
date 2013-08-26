package sh.eran.ctu.IT251;

import java.util.ArrayList;

/**
 *
 * @author eran
 */
public class Paper extends Account {
    
    private ArrayList<String> paperRecord = new ArrayList<String>();
    private double paperPrice;

    
    @Override
    public String toString() {
        
        /*
         * We're using StringBuilder in order to test it's functionality against
         * that of basic print commands. It just seems cleaner...
         */
        StringBuilder response = new StringBuilder();
                
        // First print the name
        response.append( this.getClass().getName() );
        response.append( " Object {\n" );
        
        // Append subclass specific properties
        response.append("  ").append("paperRecord : ").append( paperRecord).append("\n");
        response.append("  ").append("paperPrice : ").append( paperPrice).append("\n");
        
        response.append("}\n");
              
        // Return the output
        return response.toString();
        
    } // end method
    
    
    public Paper() {
        super();
    }

    
    Paper( double price ){
        paperPrice = price;
        System.out.println( "Paper price set at: " + paperPrice );
    }
    
    
    public double getTotalPoundsOfPaperSold(){
        double totalSold = 0;
        //@TODO Write a totalling loop
        return totalSold;
    } // end method
    
    
    public double getPaperPrice(){
        return paperPrice;
    }
    
    
    public void setPaperPrice( double newPrice ){
        paperPrice = newPrice;
    }
    
} // end class
