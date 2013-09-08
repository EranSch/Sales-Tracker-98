package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public class Supplies 
    extends Account 
    implements Account.addSale
{

    
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
        response
                .append("  ")
                .append("Date Created : ")
                .append( this.getCreatedDate() )
                .append("\n");
        
        response
                .append("  ")
                .append("Sales Record : ")
                .append( salesRecord)
                .append("\n");
        
        response
                .append("  ")
                .append("Total Sales: ")
                .append( this.getTotalSales() );

        
        response.append("\n}\n");
              
        // Return the output
        return response.toString();
        
    } // end method

    
    
    /*
     * ============================ CLASS METHODS ==============================
     */     
    
    /*
     * Playing with a new means of handling erros here. Because we only want 
     * to see a type of either Books, Supplies, or Apparel we are going to enforce
     * this by throwing an exception. Validation shall occur elsewhere. 
     */
    
    public void addSale( 
            String name, 
            String type, 
            int quantity, 
            double itemCost 
            ) {
        
        if( 
                !type.equalsIgnoreCase("book") && 
                !type.equalsIgnoreCase("supplies") &&
                !type.equalsIgnoreCase("apparel")
                ){
                        
        }
        
        salesRecord.add( new Transaction( name, type, quantity, itemCost ) );
        
    }   

    
    /*
     * While this will still return the same value as that of the superclass's,
     * it will also output some more specific stats to the console. Since this is 
     * a console based application, that may or may not be ideal. 
     */
    
    @Override
    public double computeSales() {
        
        double  totalSupplies = 0,
                totalBooks = 0,
                totalApparel = 0,
                totalSales;
                
        for( Transaction t : salesRecord ){
            
            switch( t.getDescription() ){
                
                case "book":
                    totalBooks += t.getTotal();
                    break;
                
                case "supplies":
                    totalSupplies += t.getTotal();
                    break;
                    
                case "apparel":
                    totalApparel += t.getTotal();
                    break;
                    
                default:
                    break;
                
            }
            
        }
        
        totalSales = totalSupplies + totalBooks + totalApparel;
        
        IO.print( "Total in Supplies: "  + totalSupplies );
        IO.print( "Total in Books:    "  + totalBooks );
        IO.print( "Total in Apparel:  "  + totalApparel );
        IO.print( "Total Overall:     "  + totalSales );
                
        return totalSales;
        
    }
    
    
    // This was kind of pointless anyway
    @Deprecated
    public int getTotalSales(){
        return salesRecord.size();
    }


    
}