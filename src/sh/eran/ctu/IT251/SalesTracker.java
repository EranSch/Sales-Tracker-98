package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public class SalesTracker {

    public static void main(String[] args) {
        
        // Invoke the test method!
        SalesTracker.test();
        
    }
    
    public static void test(){
        
        String line = "-----------------------------------------";
        
        Paper testPaperAccount = new Paper( 1 );
        testPaperAccount.recordPaperSale( 400 );
        testPaperAccount.recordPaperSale( 125 );
        System.out.println( "Total Pounds Sold: " + testPaperAccount.getTotalPoundsOfPaperSold() );
        System.out.println( line );
        System.out.println( testPaperAccount );
        
        System.out.println( "" );
               
        Supplies testSuppliesAccount = new Supplies();
        testSuppliesAccount.addSale( new Transaction( "Pens", "Ball Point", 500, 0.2 ) );
        testSuppliesAccount.addSale( new Transaction( "RAM", "2GB", 3, 25.95 ) );
        System.out.println( "Total Sales: " + testSuppliesAccount.getTotalSales() );
        System.out.println( line );
        System.out.println( testSuppliesAccount );
        
    }
    
}
