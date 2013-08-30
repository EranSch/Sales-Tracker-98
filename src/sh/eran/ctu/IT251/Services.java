
package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public class Services extends Account {
    
    /*
     * ========================= INSTANCE VARIABLES ===========================
     */    
    
     private int serviceRate = 50;

    /*
     * ======================== CONSTRUCTOR METHODS ============================
     */
     
     Services(){
         /*
          * While this constructor could be left blank I prefer to put something 
          * in it to remind us that this is a subclass.
          */
         super();
     }
             
     
     Services( int serviceRate ){
         this.serviceRate = serviceRate;
     }
     
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
        response.append("  ").append("Date Created : ").append( this.getCreatedDate() ).append("\n");
        response.append("  ").append("Service Rate : ").append( serviceRate).append("\n");
        response.append("  ").append("Service Record : ").append( salesRecord).append("\n");
        response.append("  ").append("Total Hours : ").append( this.getTotalHours() );
       
        response.append("\n}\n");
        
        return response.toString();
        
    }
     
     
    /*
     * ============================ CLASS METHODS ==============================
     */   
     
     // Add an item to the account's services list 
     public void recordService( String name, String description, double time ){
         salesRecord.add( new Transaction(name, description, time, serviceRate) );
     }
     
     // Return the total number of hours worked
     public double getTotalHours(){
         
        double totalHours = 0;
        
        for( int i = 0; i < this.salesRecord.size(); i++ ){
            totalHours += this.salesRecord.get(i).getQuantity();
        }
        
        return totalHours;
     }
     

    /*
     * ======================== BASIC GETTERS/SETTERS ==========================
     */
     
    public int getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(int serviceRate) {
        this.serviceRate = serviceRate;
    }
     
    
} // end class
