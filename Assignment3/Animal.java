//Declare package
package Assignment3;

//Define abstract class and interface implementations
public abstract class Animal implements Displayable, MakeSound{
    
    //Protected data fields common in animals
    protected int age;
    protected double weight;
    protected String sound;
    
    
    //Accessor and mutator methods for sound - implementations in subclasses
    public abstract String getSound();
    
    public abstract void setSound();
}



