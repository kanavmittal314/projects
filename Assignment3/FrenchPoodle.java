//Declare package
package Assignment3;

//Define class and inheritance
public class FrenchPoodle extends Dog {
    //Constructor calls mutator methods to change data fields to appropriate
    public FrenchPoodle(){
        setSound();
        setTricks();
    }
    
    //Implementation for accessor method for tricks
    @Override
    public String[] getTricks(){
        return tricks;
    }

    //Implementation for mutator method for tricks - changes only to ones for chihuahua
    @Override
    public void setTricks(){
        tricks = new String[] {"Sit up", "Lie down", "Shake hands"};
    }
    
    //Implementation for accessor method for sound
    @Override
    public String getSound(){
        return sound;
    }
    
    //Implementation for mutator method for sound
    @Override
    public void setSound(){
        sound = "Bonjour mon ami";
    }
}
