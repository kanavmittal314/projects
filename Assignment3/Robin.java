
//Declare package
package Assignment3;

//Define class and inheritance
public class Robin extends Bird{
    //Constructor calls for mutator methods to set sound to appropriate
    public Robin(){
        setSound();
    }
    
    //Implementation for accessor method for sound
    public String getSound(){
        return sound;
    }
    
    //Implementation for mutator method for sound - specific to robin
    public void setSound(){
        sound = "chirp chirp";
    }
}
