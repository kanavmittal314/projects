package Assignment8; //Define package

import java.io.Serializable; //Import Serializable interface

//Define class and implentation of Serializable interface
public class Contact implements Serializable {
    
    //Private String data fields for the contact
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    
    //No-arg constructor sets all data fields to empty Strings
    public Contact(){
        setFirstName("");
        setLastName("");
        setPhoneNumber("");
        setEmailAddress("");
    }
    
    //Parameterized constructor sets all data fields to arguments
    public Contact (String firstName, String lastName, String phoneNumber, String emailAddress){
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
    }
    
    //Accessor method for first name
    public String getFirstName(){
        return firstName;
    }
    
    //Accessor method for last name
    public String getLastName(){
        return lastName;
    }
    
    //Accessor method for phone number
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    //Accessor method for email address
    public String getEmailAddress(){
        return emailAddress;
    }
    
    //Mutator method for first name
    public void setFirstName(String firstName){
        this.firstName = capitalizeName(firstName);
    }
    
    //Mutator method for last name
    public void setLastName(String lastName){
        this.lastName = capitalizeName(lastName);
    }
    
    //Mutator method for phone number
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    //Mutator method for email address
    public void setEmailAddress(String emailAddress){
        
        //Checks for @ symbol in email address
        if (emailAddress.contains("@") && emailAddress.contains(".")){
            this.emailAddress = emailAddress;
        }
        else{
            //Display error if email address does not contain @
            System.out.println("Invalid email address"); 
        }
    }
     //Static method to capitalize the arg name
    public static String capitalizeName(String name){
        
        //Capitalize the first letter of name
        String upperCase = (name.substring(0, 1)).toUpperCase();
        
        //Keep the rest lowercase
        String lowerCase = (name.substring(1)).toLowerCase();
        
        return (upperCase + lowerCase); //Join first letter with rest of name and return
    }
}