//Define package
package Assignment7;

//Import library
import java.io.*;

//Define class and main method
public class Assignment7Input {
    public static void main(String[] args){
        
        //Serialize to "students.dat" MyStudent objects based on input data from user
        writeStudents(inputData(3),"students.dat");
    }
    
    //Method to input data for given # of students
    public static MyStudent[] inputData(int numberOfStudents){
        
        //Create array of students to hold MyStudent objects for arg numberOfStudents
        MyStudent[] students = new MyStudent[numberOfStudents];
        
        //Process through array of students
        for (int i = 1; i <= numberOfStudents; i++){
            
            //Input data about name, social security, and courses completed
            String name = Input.getString("Name of Student " + i + ": ");
            long socialSecurityNumber = Input.getLong("Social Security Number of Student " + i + ": ");
            int numberOfCoursesCompleted = Input.getInt("Number of Courses Completed by Student " + i + ": ");
            
            //Create arrays for grades and credits based on courses completed
            String[] grades = new String[numberOfCoursesCompleted];
            double[] credits = new double[numberOfCoursesCompleted];
            
            //Process through all the courses completed
            for (int j = 1; j <= numberOfCoursesCompleted; j++){
                
                //Input data and store in array based on course and student currently processing by for loop
                grades[j-1] = Input.getString("Grade for Course " + j + " for Student " + i + ": ");
                credits[j-1] = Input.getDouble("Credits for Course " + j + " for Student " + i + ": ");
            }
            
            //Create new MyStudent object based on data inputted from user and store in array
            students[i-1] = new MyStudent(name, socialSecurityNumber, numberOfCoursesCompleted, grades, credits);
        }
        return students; //Return array
    }
    
    //Method to serialize to given binary file a given array of students
    public static void writeStudents (MyStudent[] students, String binaryFile){
        
        //Try-catch with resources to create output stream
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(binaryFile)))){
            
            //Process through argument array of students 
            for (MyStudent student : students) {
                output.writeObject(student); //Serialize each student to output stream
            }
            output.close(); //Close output stream
        }
        
        //Catch any exception and display an error
        catch (Exception exception){
            System.out.println("Error!");
        }
    }
}