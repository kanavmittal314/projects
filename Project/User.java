//Define package and class
package Project;
public class User {
    
    //Data fields for name, email, payment method
    private String name;
    private String email;
    private String payment; 
    
    //Constant array of different forms of payment
    public static final String[] PAYMENT = {"Visa", "MasterCard", "Amex"};

    //No-arg constructor sets all fields to null
    public User() {
        this.name = null;
        this.email = null;
        this.payment = null;
    }

    //Parameterized constructor sets all fields to args
    public User(String name, String email, String payment) {
        setName(name);
        setEmail(email);
        setPayment(payment);
    }

    //Accessor method for name
    public String getName() {
        return name;
    }

    //Mutator method for name
    public boolean setName(String name) {
        String newName = name.trim(); //Trim off whitespace
        
        //If trimmed name is valid
        if (validateName(newName)){
            newName = capitalizeName(newName); //Capitalize name
            this.name = newName; //Set name into data field
            return true; //Return true if successful
        }
        else{
            return false; //Return false if invalid name
        }
    }

    //Accessor method for email
    public String getEmail() {
        return email;
    }

    //Mutator method for email
    public boolean setEmail(String email) {
        
        //If email is valid
        if (validateEmail(email)){
            this.email = email; //Set email into data field
            return true; //Return true if successful
        }
        else{
            return false; //Return false if invalid email
        }
    }

    //Accessor method for payment
    public String getPayment() {
        return payment;
    }

    //Mutator method for payment
    public boolean setPayment(String payment) {
        
        //If payment is valid
        if (validatePayment(payment)){
            this.payment = payment; //Set payment into data field
            return true; //Return true if successful
        }
        else{
            return false; //Return false if invalid payment
        }
    }
    
    //Static method to validate a name
    public static boolean validateName(String name){
        
        //Checks to make sure name has exactly one space and returns accordingly
        return !name.replaceFirst(" ", "").contains(" ") && name.contains(" ");
    }
    
    //Static method to validate a email
    public static boolean validateEmail(String email){
        //Checks to make sure email has an @ symbol and . after the @ and returns accordingly
        return email.contains("@") && email.substring(email.indexOf("@")).contains(".");
    }
    
    //Static method to validate a payment
    public static boolean validatePayment(String payment){
        boolean contained = false; //Boolean to be potentially changed, and returned
        //Loop through payment types array
        for (String PAYMENT1 : PAYMENT) {
            
            //If arg payment matches element in PAYMENT array, contained becomes true
            if (PAYMENT1.equals(payment)) {
                contained = true;
            }
        }
        return contained; //Return contained, true if match found so valid arg
    }
    
    //Static method to capitalize a name
    public static String capitalizeName(String name){
        String[] firstAndLastName = name.split(" "); //Split at the space
        
        //Capitalize the first name and last name, separate with a space, and return
        return (capitalizeWord(firstAndLastName[0]) + " " + capitalizeWord(firstAndLastName[1]));
    }
    
    //Static method to capitalize a word
    public static String capitalizeWord(String word){
        String firstLetter = word.substring(0, 1).toUpperCase(); //First letter uppercase
        String restOfWord = word.substring(1).toLowerCase(); //Rest of word lowercase
        return firstLetter + restOfWord; //Concatenate parts of word and return
    }
}