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
        
        Paper testPaperAccount = new Paper();
        System.out.println( line );
        System.out.println( testPaperAccount );
        
        System.out.println( "" );
               
        Supplies testSuppliesAccount = new Supplies();
        System.out.println( line );
        System.out.println( testSuppliesAccount );
        
    }
    
}
