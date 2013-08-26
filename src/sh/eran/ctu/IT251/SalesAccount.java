package sh.eran.ctu.IT251;

/**
 *
 * @author eran
 */
public abstract class SalesAccount {
    
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
            contactEmail, 
            createdDate;
    
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
    
    public String getCreatedDate(){
        return createdDate;
    }
    
    /*
     * ======================== CONSTRUCTOR METHODS ============================
     */
    
    /*
     * Until the needs of the application become more advanced, this abstract 
     * class will remain fairly simple. Two constructors will be available; one 
     * that accepts a client ID as a String and another which generates the 
     * account with no information required from the user
     * 
     * Each constructor increments the NumOfAccounts variable and assigns the 
     * value as the account's ID. This may be used later for tracking of accounts
     * and more!
     */
    
    protected SalesAccount(){
       accountID = String.valueOf(NumOfAccounts++);
       System.out.println( this.getClass().getSimpleName() + " created! ( ID: " + accountID + " )");
    }
    
    protected SalesAccount( String newClientID ){
        clientID = newClientID;
        accountID = String.valueOf(NumOfAccounts++);
        System.out.println("Account created(ID: " + accountID + ")");
    }
    
} // end class
