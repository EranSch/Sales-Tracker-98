package sh.eran.ctu.IT251;

import javax.swing.JOptionPane;

/**
 *
 * @author eran
 */
public class Paper 
    extends Account 
    implements Account.addSale
{
    
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
    
    static Paper createAccount() {
        return new Paper( IO.getDouble("Please enter the fixed paper price for this account.") );
    }
    
    @Override
    public void addSale(){
        salesRecord.add( new Transaction( "Paper", "Paper sold by the pound", IO.getDouble("Enter number of pounds sold."), this.getPaperPrice() ) );
    }
    
    public void addSale( double poundsSold ){
        salesRecord.add( new Transaction( "Paper", "Paper sold by the pound", poundsSold, this.getPaperPrice() ) );
    }

    /*
     * Although I'm aware it's unneeded, I've included this override here only to 
     * indicate that I've read the task requirments =D
     */
    
    @Override
    public double computeSales() {
        
        double totalSales = 0; // Variable to aggregate sales 
        
        for ( Transaction t : salesRecord ){ // Loop through all sales
            totalSales += t.getTotal(); 
        }
        
        IO.print( "Total Sales: " + totalSales );
        
        return totalSales; // Return
        
    }
    
    
    /*
     * Although this has been replaced by something of the same basic function, 
     * the Account subclasses should all conform in terms of exposing the same
     * basic actions. 
     * 
     * Replaced by addSale()
     * 
     */
    @Deprecated
    public void recordPaperSale( int poundsSold ){
        salesRecord.add( new Transaction( "Paper", "Paper sold by the pound", poundsSold, this.getPaperPrice() ) );
    }
    
    /*
     * Similar story; replaced by computeSales()
     */
    
    @Deprecated
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
