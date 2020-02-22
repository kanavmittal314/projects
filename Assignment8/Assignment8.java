package Assignment8; //Define package

//Import libraries
import java.io.*;
import java.util.*;
 //Define class and main method
public class Assignment8 {
    public static void main(String[] args){
        
        //Create empty tree map with String keys and Contact values
        TreeMap<String, Contact> contactMap = new TreeMap();
        
        String fileName = getFileName(); //Input file name
        int userChoice; //Declare user choice variable (used in do-while loop)
        
        //Do-while loop to continue repeating till user decides to quit
        do{
           userChoice = getUserChoice();  //Input user choice
           
           //Switch structure based on user choice
           switch (userChoice){
               case 1: addContact(fileName, contactMap); break; //If user picks 1, add a contact
               case 2: deleteContact(fileName, contactMap); break; //If user picks 2, delete a contact
               case 3: displayContacts(contactMap); break; //If user picks 3, display contacts
               case 4: break; //If user picks 4, do nothing
           }
           
           //After executing command, read the contacts and store in contactMap for next user command
           contactMap = readContacts(fileName); 
           
           
        } while (userChoice != 4); //Exit out of loop when user picks 4
    }
    
    //Method that inputs file name from user and returns as String
    public static String getFileName(){
        String fileName = Input.getString("Enter the file name: "); //Input file name
        
        //Add .dat file extension if not already in file name
        if (!fileName.endsWith(".dat")){
            fileName += ".dat";
        }
        return fileName; //Return the file name guaranteed with .dat at the end
    }
    
    //Method that inputs choice from user and returns as integer
    public static int getUserChoice(){
        
        //Initialize prefix to message to "" and user choice to 0, but will be changed later
        String prefix = "";
        int userChoice = 0;
        
        //Do-while loop to continue asking for user choice until valid entry
        do{
            //Try-catch for potential exceptions
            try{
                userChoice = Input.getInt(prefix + " Enter 1 to add a contact, 2 to delete a contact, 3 to display the entire contact list, and 4 to quit the program:");
            }
            
            //Catch not required but added to prevent termination when non-integer entered
            catch (NumberFormatException exception){
            }
            prefix = "Invalid user choice."; //Set prefix to error message for future iterations
            
                //Ensure that user choice is integer from 1 to 4
        } while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4); 
        return userChoice; //Return user choice
    }
    
    //Method that adds contact to arg contactMap and serializes to arg fileName
    public static void addContact(String fileName, TreeMap<String, Contact> contactMap){
        Contact contact = inputContact(); //Input contact from user and store in new Contact
        
        //Add contact to tree map with the last name as key
        contactMap.put(contact.getLastName(), contact);
        
        //Serialize contact map to file
        serializeContactMap(fileName, contactMap);
        
    }
    
    //Method to input contact
    public static Contact inputContact(){
        //Create and return Contact object based on Input.getString() from user
        return new Contact(Input.getString("Enter the first name:"), 
                Input.getString("Enter the last name:"), 
                Input.getString("Enter the phone number:"), 
                Input.getString("Enter the email address:"));
    }
    
    //Method to delete contact from arg contactMap and serialize contactMap to fileName
    public static void deleteContact(String fileName, TreeMap<String, Contact> contactMap){
        String lastName; //Declare String to hold the key last name
        String prefix = ""; //Initialize prefix String to empty
        
        //Do-while loop to continue iterating until valid last name entered
        do{
            //Input the last name from user, capitalize last name, and store in lastName
            lastName = Contact.capitalizeName(Input.getString(prefix + "Enter the last name of the contact you would like to delete: "));
            prefix = "Last name not found. "; //Change prefix for future iterations
        }while(!contactMap.containsKey(lastName)); //Ensure that last name is a key within tree map
        
        contactMap.remove(lastName); //Remove entry with key of last name from contact map
        
        //Serialize contact map to file
        serializeContactMap(fileName, contactMap);
    }
    
    //Method to serialize arg contactMap to file with arg fileName
    public static void serializeContactMap(String fileName, TreeMap<String, Contact> contactMap){
        //Try with resources to create output stream
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
            output.writeObject(contactMap); //Serialize contactMap to output stream
        }
        //Display error for IOException
        catch (IOException ioException){
            System.out.println("IOException when adding contact");
        }
    }
    
    
    //Method to read contacts from arg file using deserialization
    public static TreeMap<String, Contact> readContacts(String fileName){
        TreeMap<String, Contact> contactMap = null; //Create null contact map
        
        //Try with resources to create input stream
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
            //Read object from input stream and cast to TreeMap<String, Contact> to store in contact map
            contactMap = (TreeMap<String, Contact>) input.readObject(); 
        }
        
        //Catch various exceptions and display pertinent error messages
        catch (NullPointerException e){
            System.out.println("No information in file when reading contacts. ");
        }
        catch (IOException e){
            System.out.println("Error when reading contacts. ");
        }
        catch (ClassNotFoundException e){
            System.out.println("File not found when reading contacts. ");
        }
        return contactMap;
    }
    
    //Method to display contacts from arg contactMap
    public static void displayContacts(TreeMap<String, Contact> contactMap){
        System.out.println(); //Create whitespace
        
        //Iterate through contactMap
        for (Map.Entry<String, Contact> entry : contactMap.entrySet() ){
            Contact contact = entry.getValue(); //Current contact is the value of the entry
            
            //Print out first name, last name, phone number, and email address
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + " can be reached at " + contact.getPhoneNumber() + " or at " + contact.getEmailAddress() + ".");
        }
    }
}