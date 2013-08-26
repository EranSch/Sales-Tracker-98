package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public class SalesTracker {

    public static void main(String[] args) {
        
        SalesTracker.test();
        
    }
    
    public static void test(){
        
        String line = "-----------------------------------------";
        
        PaperAccount testAccount = new PaperAccount( 50 );
        System.out.println( line );
        System.out.println( testAccount.toString() );
        
    }
    
}
