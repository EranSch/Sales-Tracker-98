package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public class SalesTracker {

    public static void main(String[] args) {
        
        // Invoke the test method (defined below)!
        SalesTracker.test();
        
    }
    
    public static void test(){
        
        // Just some formatting strings
        String line = "-----------------------------------------";
        String dblLine = "=============";
        
    /*
     * =========================== PAPER ACCOUNTS =============================
     */   
        
        /*
         * Print label and instantiate the object.. 
         */
        System.out.println( dblLine + " PAPER ACCOUNT TEST " + dblLine); 
        Paper testPaperAccount = new Paper( 1 );
        
        /*
         * Using a method of Paper class, we'll record some sales...
         */
        testPaperAccount.recordPaperSale( 400 );
        testPaperAccount.recordPaperSale( 125 );
        
        /*
         * Now that the object has seen some action, lets look at the results...
         * Notice, on line 42, that we're invoking the toString method of the 
         * object by printing its reference name to the console.
         */
        System.out.println( "Total Pounds Sold: " + testPaperAccount.getTotalPoundsOfPaperSold() );
        System.out.println( line );
        System.out.println( testPaperAccount );
        
        
    /*
     * =========================== SUPPLY ACCOUNTS =============================
     */  
        
        /*
         * Print label and instantiate the object.. 
         */        
        System.out.println( "\n" + dblLine + " SUPPLY ACCOUNT TEST " + dblLine);
        Supplies testSuppliesAccount = new Supplies();
        
        /*
         * Once again, transactions are recorded using a local method. In this 
         * instance, more data is required by the method in order to make a 
         * succesful sale.
         */
        testSuppliesAccount.addSale( new Transaction( "Pens", "Ball Point", 500, 0.2 ) );
        testSuppliesAccount.addSale( new Transaction( "RAM", "2GB", 3, 25.95 ) );
        
        /*
         * Finally, we'll see what data has been accumulated in the object.
         */
        System.out.println( "Total Sales: " + testSuppliesAccount.getTotalSales() );
        System.out.println( line );
        System.out.println( testSuppliesAccount );
        
        
    /*
     * =========================== SERVICE ACCOUNTS ============================
     */          
        
        /*
         * Print label and instantiate the object.. 
         */        
        System.out.println( "\n" + dblLine + " SERVICES ACCOUNT TEST " + dblLine);
        Services testServicesAccount = new Services();
        
        /*
         * Because the rate is defined as a property of the class, there's no 
         * need to require it when recording sales here. Instead, the rate can be
         * changed via the class's getters/setters.
         */
        testServicesAccount.recordService("PC Repair", "Formatted and reinstalled OS", 3.25);
        testServicesAccount.recordService("PC Repair", "Removed spywayre", 0.125);
        
        /*
         * Watch as the Services class outputs its glorious properties!
         */
        System.out.println( "Total Hours: " + testServicesAccount.getTotalHours() );
        System.out.println( line );
        System.out.println( testServicesAccount );
    }
    
}
