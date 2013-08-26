package sh.eran.ctu.IT251;

import java.util.ArrayList;

/**
 *
 * @author eran
 */
public class Supplies extends Account {
    
    private ArrayList<String> salesRecord = new ArrayList<String>();
    
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
        response.append("  ").append("salesRecord : ").append( salesRecord).append("\n");
        //response.append("  ").append("paperPrice : ").append( paperPrice).append("\n");
        
        response.append("}\n");
              
        // Return the output
        return response.toString();
        
    } // end method
    
    
}
