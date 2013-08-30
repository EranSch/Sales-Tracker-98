package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public class Paper extends Account {
    
    /*
     * ========================= INSTANCE VARIABLES ===========================
     */ 
    
    private double paperPrice;

    
    
    /*
     * ======================== CONSTRUCTOR METHODS ============================
     */  
    
    Paper(){
        /*
         * It seems that the subclass won't use the overridden no-args constructor
         * of the superclass unless this empty constructor is defined. Weird...
         */
    }
    
    Paper( double price ){
        paperPrice = price;
        System.out.println( "Paper price set at: " + paperPrice );
    }
    
    
    
    /*
     * ========================= toString() METHOD =============================
     */
    
    @Override
    public String toString() {
        
        /*
         * We're using StringBuilder in order to test it's functionality against
         * that of basic print commands. It just seems cleaner... Perhaps there
         * are some other benefits too...
         */
        
        StringBuilder response = new StringBuilder();
                
        // First print the name
        response.append( this.getClass().getName() );
        response.append( " Object {\n" );
        
        // Append subclass specific properties
        response.append("  ").append("Date Created : ").append( this.getCreatedDate() ).append("\n");
        response.append("  ").append("Paper Record : ").append( salesRecord).append("\n");
        response.append("  ").append("Paper Price : ").append( paperPrice).append("\n");
        response.append("  ").append("Total #'s Sold: ").append( this.getTotalPoundsOfPaperSold() ).append("\n");
        
        response.append("}\n");
              
        // Return the output
        return response.toString();
        
    } // end method
    
    
    
    /*
     * ============================ CLASS METHODS ==============================
     */     
    
    public void recordPaperSale( int poundsSold ){
        salesRecord.add( new Transaction( "Paper", "Paper sold by the pound", poundsSold, this.getPaperPrice() ) );
    }
    
    public double getTotalPoundsOfPaperSold(){
        double totalSold = 0;
        
        for( int i = 0; i < this.salesRecord.size(); i++ ){
            totalSold += this.salesRecord.get(i).getQuantity();
        }
        
        return totalSold;
    } // end method
    
    
    
    /*
     * ======================== BASIC GETTERS/SETTERS ==========================
     */    
    
    public double getPaperPrice(){
        return paperPrice;
    }
    
    public void setPaperPrice( double newPrice ){
        paperPrice = newPrice;
    }
    
} // end class
