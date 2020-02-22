package Project2;

//Create class for hare objects
public class Hare{
    //Declare int data fields to represent positions of hare
    private int position; //Private position of hare
    private int maxPosition; //Private maximum possible position of hare
    public static final int MIN_POSITION = 1; //Public static constant minimum position of hare
    
    //Declare public constant int data fields to represent movements of tortoise
    public final int BIG_HOP = 9; //Big hop moves hare 9 forward
    public final int SMALL_HOP = 1; //Small hop moves hare 1 forward
    public final int BIG_SLIP = -12; //Big slip moves hare -12 forward, or 12 back
    public final int SMALL_SLIP = -2; //Small slip moves hare -2 forward, or 2 back
    public final int FALL_ASLEEP = 0; //Fall asleep keeps hare still
    
    //Constructor - takes in # of squares as arg
    public Hare(int numberOfSquares){
        setMaxPosition(numberOfSquares); //Set maximum position to the number of racing squares, or end of race
        setPosition(MIN_POSITION); //Set current position to minimum position, or start of race
    }
    
    //Accessor method - returns current position of hare
    public int getPosition(){
        return position;
    }
    
    //Mutator method - sets current position to arg (private to ensure only way to change pos is to use bigHop(), smallHop(), bigSlip(), and smallSlip())
    private void setPosition(int position){
        //If-else construct to validate arg
        if (position >= MIN_POSITION && position <= maxPosition){
            this.position = position; //Sets current position to arg 
        } 
        else if (position < MIN_POSITION){
            this.position = 1; //Sets current position to one if arg less than min position
        }
        else{
            this.position = maxPosition; //Sets current position to max position if arg more than min position
        }
    }
    
    //Accessor method - returns max position of hare
    public int getMaxPosition(){
        return maxPosition;
    }
    
    //Mutator method - sets max position to arg
    public void setMaxPosition(int maxPosition){
        //If construct to validate arg
        if (maxPosition >= MIN_POSITION){
            this.maxPosition = maxPosition; //Sets max position to arg if max position greater than min position
        }
        else{
            System.out.println("Invalid input!!!"); //Displays error message if max position less than min position
        }
    }
    
    //Method to represent big hop of hare
    public void bigHop(){
        setPosition(position + BIG_HOP); //Sets position to after a big hop
    }
    
    //Method to represent small hop of hare
    public void smallHop(){
        setPosition(position + SMALL_HOP); //Sets position to after a small hop
    }
    
    //Method to represent big slip of hare
    public void bigSlip(){
        setPosition(position + BIG_SLIP); //Sets position to after a big slip
    }
    
    //Method to represent small slip of hare
    public void smallSlip(){
        setPosition(position + SMALL_SLIP); //Sets position to after a small slip
    }
    
    //Method to represent sleep of hare
    public void fallAsleep(){
        setPosition(position + FALL_ASLEEP); //Sets position to after a nap
    }
    
    //Method to move the hare. Takes in hare obj and the random-generated #
    public void moveHare(int randomNumber){
        //Use switch statement depending on rand #
        switch(randomNumber){
            //If rand # is 1 or 2, hare does bigHop()
            case 1:
            case 2:
                bigHop();
                break;
            //If rand # is b/w 3 and 5, hare does smallHop()
            case 3:
            case 4:
            case 5:
                smallHop();
                break;
            //If rand # is 6, hare does bigSlip()
            case 6:
                bigSlip();
                break;
            //If rand # is 7 or 8, hare does smallSlip()
            case 7:
            case 8:
                smallSlip();
                break;
            //If rand # is 9 or 10, hare does fallAsleep()
            case 9:
            case 10:
                fallAsleep();
                break;  
        }
    }
}    

