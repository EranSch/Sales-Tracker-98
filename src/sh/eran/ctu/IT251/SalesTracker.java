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
        
        SalesAccount testAccount = new SalesAccount( "test" );
        System.out.println(testAccount.getAccount());
        
    }
    
}
