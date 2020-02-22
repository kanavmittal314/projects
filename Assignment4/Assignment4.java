//Define package, class, and main method
package Assignment4;

public class Assignment4 {
    public static void main(String[] args){
        
        //Declare and initialize class variables
        boolean validDenominator = false; //Boolean holds whether valid denominator entered yet
        int denominator = Input.getInt("Enter denominator: "); //Holds denominator
        
        //While loop reiterates until valid denominator entered
        while (!validDenominator){
            
            //Try block tries to divide() 10 by the denominator and display result
            try{
                System.out.println("10 divided by " + denominator + " equals " + divide(10, denominator) + ".");
                validDenominator = true; //If no exception thrown, valid denominator turns to true
            }
            //Catch block catches a divide by zero exception and prompts user to reenter denominator
            catch(DivideByZeroException divideByZeroException){
               denominator = Input.getInt("Denominator must be nonzero. Reenter: ");
            }
        }
    }
    
    //Divide method that divides arguments and throws a DivideByZero exception
    public static int divide(int numerator, int denominator) throws DivideByZeroException{
        int result = 0; //Declare and initialize preliminary result
        
        //Try block tries to divide arguments
        try{
            result = numerator/denominator;
        }
        //Catch block catches an arithmetic exception and throws a divide by zero exception to main()
        catch(ArithmeticException arithmeticException){
            throw new DivideByZeroException(denominator);
        }
        return result; //return result
    }
}
