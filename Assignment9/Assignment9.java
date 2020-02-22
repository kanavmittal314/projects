//Define package, import, class,  and main method
package Assignment9;
import java.util.Random;
public class Assignment9 {
    public static void main(String[] args){
        
       //Target is random integer from 0 to 1000
       int target = (new Random()).nextInt(1001);
       
       //Create three threads with specified ranges using Findit constructors
       Thread thread1 = new Findit(target, 0, 349);
       Thread thread2 = new Findit(target, 350, 699);
       Thread thread3 = new Findit(target, 700, 1000);
       
       //Start the three threads
       thread1.start();
       thread2.start();
       thread3.start();
       
    }
}
