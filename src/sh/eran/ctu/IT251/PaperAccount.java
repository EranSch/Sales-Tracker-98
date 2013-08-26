package sh.eran.ctu.IT251;

import java.util.ArrayList;

/**
 *
 * @author eran
 */
public class PaperAccount extends SalesAccount {
    
    private ArrayList<String> paperRecord = new ArrayList<String>();
    private double paperPrice;
    
    PaperAccount( double price ){
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
