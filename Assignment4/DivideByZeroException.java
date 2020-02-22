//Define package
package Assignment4;

//Define class and inheritance
public class DivideByZeroException extends Exception {
    
    //Data field for the denominator
    private int denom;
    
    //No paramter constructor
    public DivideByZeroException(){
        super();
    }
    
    //Paramter constructor with a String
    public DivideByZeroException(String s){
        super(s);
    }
    
    //Parameter constructor with an integer as the denominator
    public DivideByZeroException(int d){
        super ("div by zero");
        denom = d;
    }
    
    //Accessor method for denominator
    public int getDenominator(){
        return denom;
    }
}
