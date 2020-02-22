//Define package
package Assignment9;

//Define class and inheritance
public class Findit extends Thread{
    
    //Private integer data fields for the relevant information - target #, start and end range
    private int target;
    private int start;
    private int end;    
    
    //Parameterized constructor that sets data fields to values of args
    public Findit(int target, int start, int end){
        this.target = target;
        this.start = start;
        this.end = end;
    }
    
    
    //Method executed when thread runs, overrides run() in Thread
    @Override
    public void run(){
        
        //Boolean to determine if for loops should continue
        boolean shouldContinue = true;
        
            
        //For-loop iterates through start to end range in packages of 10
        for (int j = start; j <= end; j += 10){
                
            //For-loop iterates through each package of 10
            for (int i = j; i < (j + 10); i++){
                    
                //Checks if current iteration matches target
                if (target == i){
                        
                    //Prints the thread name and found #
                    System.out.println(this.getName() + " found " + i + ".");
                    shouldContinue = false; //Changes boolean in order to exit for loops
                    break; //Breaks from inner for loop
                }
            }
            
            //Breaks from outer for loop if should not continue
            if (!shouldContinue){
                break;
            }
            
            Thread.yield(); //After each package of 10, yield to other threads    
        }       
    }
}