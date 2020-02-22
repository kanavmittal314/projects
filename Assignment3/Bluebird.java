//Declare package
package Assignment3;

//Define class and inheritance
public class Bluebird extends Bird{
    
    //Constructor calls for mutator methods to change sound to appropriate
    public Bluebird(){
        setSound();
    }

    //Implementation for accessor method
    public String getSound(){
        return sound;
    }

    //Implementation for mutator method - specific to bluebird
    public void setSound(){
        sound = "eek eek eek";
    }
}