package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public class Supplies extends Account {

    /*
     * ========================= INSTANCE VARIABLES ===========================
     */        
        
    

    /*
     * ========================= toString() METHOD =============================
     */    
    
    @Override
    public String toString() {

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

    
    
    /*
     * ============================ CLASS METHODS ==============================
     */     
    
    public void addSale( Transaction sale ){
        salesRecord.add( sale );
    }   
    
    public int getTotalSales(){
        return salesRecord.size();
    }
    
}
