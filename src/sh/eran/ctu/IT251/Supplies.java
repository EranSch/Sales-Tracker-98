package sh.eran.ctu.IT251;

import java.util.ArrayList;

/**
 *
 * @author eran
 */
public class Supplies extends Account {
    
    private ArrayList<Transaction> salesRecord = new ArrayList<Transaction>();
    
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
        response.append("  ").append("Date Created : ").append( this.getCreatedDate() ).append("\n");
        response.append("  ").append("Sales Record : ").append( salesRecord).append("\n");
        response.append("  ").append("Total Sales: ").append( this.getTotalSales() );

        
        response.append("\n}\n");
              
        // Return the output
        return response.toString();
        
    } // end method
    
    public void addSale( Transaction sale ){
        salesRecord.add( sale );
    }
    
    public int getTotalSales(){
        return salesRecord.size();
    }
    
}
