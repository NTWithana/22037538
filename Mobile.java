public class Mobile extends Gadget {

public static void main(String[] args) {

}
    
    
    
private int creditBal; // One attribute that belongs to this class
        
    // Constructor for the mobile subclass
public Mobile(String gadmodel, String gadsize, double gadprice, int gadweight, int creditbal) {
        super(gadmodel, gadsize, gadprice, gadweight); // Calling the superclass constructor
        creditBal = creditbal;

}

    // Accessor method for credit balance
public int getCreditBal() {
        return creditBal;
}

    // Method to add credit for the call
public void addCreditBal(int mins) { // Mins refers to the duraion of the call                  
        if (mins > 0) {
            creditBal += mins;
        } else {
            System.out.println("Please enter credit before making the call");
        }
}

public void takeCall(String telenum, int calltime) {
        if (creditBal >= calltime) { //method to check if theirs enough credit to make the call
            System.out.println("In a call with " + telenum + " for " + calltime + " Mins..");
            creditBal -= calltime; //deduct the call duration from the credit balance
        } else {
            System.out.println("INSUFFICIENT CREDIT TO MAKE THE CALL. PLEASE RECHARGE AND TRY AGAIN");
        }
}

public void prompt() {
        super.prompt(); // Call the superclass (Gadget) to retrieve excisting display methods. 
        System.out.println("Remaining Credit Balance: " + creditBal);// display remaining credit balance
}

    

}
