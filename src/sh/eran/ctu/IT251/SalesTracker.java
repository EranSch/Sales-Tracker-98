package sh.eran.ctu.IT251;

import java.util.Random;

/**
 * @author eran
 */
public class SalesTracker {

    public static void main(String[] args) {
        
        // Invoke the test method (defined below)!
        SalesTracker test = new SalesTracker();
        test.testIP3();
        
    }

    /*
    * This test will demonstrate the true value of polymorphism in terms
    * of subclasses inheriting methods from abstract superclasses. 
    * 
    * Because this is kind of boring, we'll spice it up by at least making 
    * the test group really big! Now I know, this wouldn't be the practical 
    * way of doing something like this IRL but who cares?
    */

    private void testIP3() {
        
        // How does 10,000 test accounts sound?
        Account [] accounts = new Account[10000];
        
        /*
         * In order to create a mix of the different subclasses, we'll use some
         * simple iteration logic to rotate what's instantiated for each position
         * in the array.
         */
        int rotator = 0;
        
        // Also, lets see how long this all takes. MMkay?
        long timeStart = System.currentTimeMillis();
        
        // We'll also use some random numbers for everying... For fun. 
        Random rg = new Random();
        
        for( int i = 1; i < accounts.length; i++ ){
            switch (rotator){
                case 0:
                    accounts[i] = new Paper( 1 );
                    ((Paper)accounts[i]).addSale( ( rg.nextInt(1000) * 10 ) );
                    rotator++;
                    break;
                case 1:
                    accounts[i] = new Services();
                    ((Services)accounts[i]).addSale("PC Repair", "Formatted and reinstalled OS", (rg.nextDouble() * 30) );
                    rotator++;
                    break;
                case 2:
                    accounts[i] = new Supplies();
                    ((Supplies)accounts[i]).addSale( "T-shirt", "apparel", ( rg.nextInt(1000) * 10 ), 0.2 );
                    rotator = 0;
                    break;
            }
        }
            
        /*
         * That was fun! 
         */
            
        IO.clearConsole();
        IO.print( accounts.length + " Accounts created in " + ( System.currentTimeMillis() - timeStart ) + "ms" );
            
        if(IO.getConfirm( "Would you like to compute the total sales?" )){

            long aggregateTotal = 0;
            timeStart = System.currentTimeMillis();
            
            /*
             * So here's the bread and butter of this beast-- We can now iterate
             * through the entire array of subclasses and call upon each with the
             * overridden, abstract method computeSales. Because the method is 
             * abstract in the superclass, no casting or anything needs to happen
             * because it's an expected behavior of Account. Woohoo!
             */

            for( int i = 1; i < accounts.length; i++ ){
                System.out.println( aggregateTotal += accounts[i].computeSales() );
            }   

            IO.clearConsole();
            IO.print("Total Sales across all accounts: $" + String.valueOf(aggregateTotal));
            IO.print( "Calculated in " + ( System.currentTimeMillis() - timeStart ) + "ms" );

        }else{
            System.exit(0);
        }
        
    }
    
    /*
     * Test method for IP1/2
     */
    
    @Deprecated
    private void testIP2(){
        
        // Just some formatting strings
        String line = "\n";
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
        testPaperAccount.addSale( 400 );
        testPaperAccount.addSale( 125 );
        
        /*
         * Now that the object has seen some action, lets look at the results...
         * Notice, on line 42, that we're invoking the toString method of the 
         * object by printing its reference name to the console.
         */

        testPaperAccount.computeSales();
        
        
    /*
     * =========================== SUPPLY ACCOUNTS =============================
     */  
        
        /*
         * Print label and instantiate the object.. 
         */        
        System.out.println( "\n" + dblLine + " SUPPLY ACCOUNT TEST " + dblLine);
        Supplies testSuppliesAccount = new Supplies();
        
        
        /*
         * This got a little weird. I wanted to play with throwing an exception 
         * if the description type didn't match one of the allowed categories.
         * I'm really not sure if this is the smart way to do this or not,
         * Obviously there woulb need to be some more interactive validation 
         * going on but I figure that would be something left to the interface...
         */
        try {
            testSuppliesAccount.addSale( "T-shirt", "apparel", 500, 0.2 );
        } catch (Exception ex) {
            IO.print(ex.toString());
        }
        
        try {
            testSuppliesAccount.addSale( "Pens", "supplies", 3000, 0.05 );
        } catch (Exception ex) {
            IO.print(ex.toString());
        }
        
        try {
            testSuppliesAccount.addSale( "Java How to Program: Early Objects Version", "book", 3, 25.95 );
        } catch (Exception ex) {
            IO.print(ex.toString());
        }

        try {
            testSuppliesAccount.addSale( "This should break", "Disallowed Item", 3, 25.95 );
        } catch (Exception ex) {
            IO.print(ex.toString());
        }
        
        /*
         * Finally, we'll see what data has been accumulated in the object.
         */
        testSuppliesAccount.computeSales();
        
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
        testServicesAccount.addSale("PC Repair", "Formatted and reinstalled OS", 3.25);
        testServicesAccount.addSale("PC Repair", "Removed spywayre", 0.125);
        
        /*
         * Watch as the Services class outputs its glorious properties!
         */
        testServicesAccount.computeSales();
        
       IO.print( line );
       
       
       /*
        * In order to produce cleaner output yet still keep testing as verbose as
        * possible, the toString outputs of each test class have been moved here 
        * and have been made optional via prompt at the console. 
        */
        
       if( IO.getConfirm("Would you like the view the object contents?") ){
           
           IO.print( testPaperAccount.toString() );
           IO.print( testSuppliesAccount.toString() );
           IO.print( testServicesAccount.toString() );
           
       }
        
    } 
    
}
