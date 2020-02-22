//Define package
package Assignment7;

//Import libraries
import java.io.*;

//Define class and implementation of Serializable interface
public class MyStudent implements Serializable {
    
    //Private data fields for students
    private String name;
    private long socialSecurityNumber;
    private int numberOfCompletedCourses;
    private String[] gradesForCourses = {""}; //Must initialize for calculateGPA() to compile
    private double[] creditsForCourses = {0}; //Must initialize for calculateGPA() to compile
    
    //Reference arrays made constant to find GPA based on grade
    final String[] REFERENCE_GRADES = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
    final double[] REFERENCE_GPA = {4.0, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0};
    
    /*No-parameter constructor sets name, social security, and completed courses to empty or 0
    Grades for courses and credits for courses already initialized */
    public MyStudent(){
        setName("");
        setSocialSecurityNumber(0);
        setNumberOfCompletedCourses(0);
    }
    
    //Parameterized constructor sets data fields to arguments
    public MyStudent(String name, long socialSecurityNumber, int numberOfCompletedCourses, String[] gradesForCourses, double[] creditsForCourses){
        setName(name);
        setSocialSecurityNumber(socialSecurityNumber);
        setNumberOfCompletedCourses(numberOfCompletedCourses);
        setGradesForCourses(gradesForCourses);
        setCreditsForCourses(creditsForCourses);
    }
    
    //Accessor method for name
    public String getName(){
        return name;
    }
    
    //Accessor method for social security 
    public long getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
    
    //Accessor method for # of completed courses
    public int getNumberOfCompletedCourses(){
        return numberOfCompletedCourses;
    }
    
    //Accessor method for grades for courses
    public String[] getGradesForCourses(){
        return gradesForCourses;
    }
    
    //Accessor method for credits for courses
    public double[] getCreditsForCourses(){
        return creditsForCourses;
    }
    
    //Mutator method for name
    public void setName(String name){
        this.name = name;
    }
    
    //Mutator method for social security
    public void setSocialSecurityNumber(long socialSecurityNumber){
        this.socialSecurityNumber = socialSecurityNumber;
    }
    
    //Mutator method for number of completed courses
    public void setNumberOfCompletedCourses(int numberOfCompletedCourses){
        this.numberOfCompletedCourses = numberOfCompletedCourses;
    }
    
    //Mutator method for grades for courses
    public void setGradesForCourses(String[] gradesForCourses){
        this.gradesForCourses = gradesForCourses;
    }
    
    //Mutator method for credits for courses
    public void setCreditsForCourses(double[] creditsForCourses){
        this.creditsForCourses = creditsForCourses;
    }
    
    //Method to calculate GPA
    public double calculateGPA(){
        double GPA = 0.0; //Start off with a GPA at 0
        
        //Process through grades for courses array
        for (int i = 0; i < gradesForCourses.length; i++){
            
            //Process through reference grades array
            for (int j = 0; j < REFERENCE_GRADES.length; j++){
                
                //Check to see if match between reference grade and grades for courses
                if (REFERENCE_GRADES[j].equalsIgnoreCase(gradesForCourses[i])){
                    
                    /*Add to GPA the corresponding GPA to the grade from reference
                    times the corresponding credits for the course*/
                    GPA += creditsForCourses[i] * REFERENCE_GPA[j];
                }
            }
        }
        
        //At this point, GPA will be very high because not yet divided by # of credits
        
        double totalCredits = 0; //Start off with total credits at 0
        
        //Process through credits for courses array
        for (int i = 0; i < creditsForCourses.length; i++){
            
            //Add up the credits for courses to get total
            totalCredits += creditsForCourses[i];
        }
        
        //Divide GPA by total credits
        GPA = GPA/totalCredits;
        
        //Round GPA to two decimal places by scaling it by 100 and then rounding
        GPA *= 100;
        GPA = Math.round(GPA);
        GPA = GPA/100;
        
        //Return final GPA
        return GPA;
    }
}