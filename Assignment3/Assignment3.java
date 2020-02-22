
//Package declaration
package Assignment3;

//Import Random library
import java.util.Random;

//Define driver class
public class Assignment3 {
    
    //Main method - generates array, finds appropriate Animal with random index, and displays sound of Animal
    public static void main(String[] args){
        displaySound(generateArray()[generateRandomNumber()]);
    }
    
    //Method to return an array with four different animals
    public static Animal[] generateArray(){
        return new Animal[]{new Robin(), new Bluebird(), new FrenchPoodle(), new Chihuahua()};
    }
    
    //Method to return random number from 0 to 3
    public static int generateRandomNumber(){
        return new Random().nextInt(4);
    }
    
    //Method to display sound of parameter Animal using abstract method animal but implementation in classes
    public static void displaySound(Animal animal){
        System.out.println(animal.getSound());
    }
}
