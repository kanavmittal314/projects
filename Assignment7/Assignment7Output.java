//Define package
package Assignment7;

//Import library
import java.io.*;

//Define package and main method
public class Assignment7Output {
    public static void main(String[] args){
        
        //Read MyStudent objects from given binary file for 3 students
        readStudents("students.dat", 3);
    }
    
    //Method to read myStudent objects from arg binary file for arg # of students
    public static void readStudents (String binaryFile, int numberOfStudents){
       
        //Try-catch with resources to create input stream
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("students.dat")))){
            
            //Process through all students
            for (int i = 0; i < numberOfStudents; i++){
                
                //Read object from input stream and cast to MyStudent
                MyStudent student = (MyStudent)input.readObject();
                
                //Display the student
                displayStudent(student);
            }
            input.close(); //Close input stream
        }
        
        //Catch exception and display error message
        catch (Exception exception){
            System.out.println("Error!");
        }
    }
    
    //Method to display arg student
    public static void displayStudent(MyStudent student){
        
        //Print out name of student and GPA using instance methods
        System.out.println(student.getName() + " has a GPA of " + student.calculateGPA() + ".");
    }
}