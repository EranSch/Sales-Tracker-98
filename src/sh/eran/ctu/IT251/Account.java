package sh.eran.ctu.IT251;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author eran
 */
public abstract class Account {
    
    /*
     * ======================= STATIC CLASS VARIABLES ==========================
     */    
    
    // Class variable for tracking the total number of account instances
    static int NumOfAccounts = 0;

    /*
     * ========================= INSTANCE VARIABLES ===========================
     */      
    
    private String 
            accountID, 
            clientID, 
            contactName,
            contactPhone, 
            contactEmail;
    
    private Date createdDate;
    
    protected ArrayList<Transaction> salesRecord = new ArrayList<>();
    
    
    /*
     * ======================== CONSTRUCTOR METHODS ============================
     */
    
    /*
     * Until the needs of the application become more advanced, this abstract 
     * class will remain fairly simple.
     */
    
    protected Account(){
        
       accountID = String.valueOf(NumOfAccounts++);
       this.createdDate = Calendar.getInstance().getTime();
       
       System.out.println( this.getClass().getSimpleName() + " created! ( Account ID: " + accountID + " )");
    }

    
    /*
     * ============================ CLASS METHODS ==============================
     */      
    
    /*
     * Not sure that I really need to define this as it must be overridden in all
     * of the existing subclasses but whatever. I suppose it does serve as a good
     * defualt or guide for the basic implementation.
     */
    
    public void addSale( 
            String name, 
            String description,
            double quantity,
            double itemCost ){
        
        salesRecord.add( new Transaction( name, description, quantity, itemCost ) );
        
    }
    
    /*
     * Same deal here, this will just be a generic implementation and should be
     * customized to the sale type in each subclass. 
     */
    
    public double computeSales(){
        
        double totalSales = 0; // Variable to aggregate sales 
        
        for ( Transaction t : salesRecord ){ // Loop through all sales
            totalSales += t.getTotal(); 
        }
        
        return totalSales; // Return
        
    }
    
    
    /*
     * ======================== BASIC GETTERS/SETTERS ==========================
     */
    
    public String getAccount(){
        return accountID;
    } 
    
    public String getClientID(){
        return accountID;
    } 
    
    public void setClientID( String accountNumber ){
        clientID = accountNumber;
    } 
    
    public String getContactName(){
        return contactName;
    } 
    
    public void setContactName( String name ){
        contactName = name;
    }
    
    public String getContactPhone(){
        return contactPhone;
    }
    
    public void setContactPhone( String phone ){
        contactPhone = phone;
    }
    
    public String getContactEmail(){
        return contactEmail;
    }
    
    public void setContactEmail( String email ){
        contactEmail = email;
    }
    
    public Date getCreatedDate(){
        return createdDate;
    }
        
} // end class
