package Project2;

//Create class for tortoise objects
public class Tortoise{
    //Declare int data fields for the positions
    private int position; //Private position of tortoise
    private int maxPosition; //Privaate maximum possible position of tortoise 
    public static final int MIN_POSITION = 1; //Public static constant for minimum position
    
    //Public static constant int data fields to represent movements of tortoise
    public static final int FAST_PLOD = 3; //Fast plod moves tortoise 3 forward
    public static final int SLOW_PLOD = 1; //Slow plod moves tortoise 1 forward
    public static final int SLIP = -6; //Slip moves tortoise -6 forward, or 6 back
    
    //Constructor - takes in # of squares as arg
    public Tortoise(int numberOfSquares){
        setMaxPosition(numberOfSquares); //Sets the maximum position of the tortoise at the number of racing squares, or the end of the race
        setPosition(MIN_POSITION); //Sets the position to the minimum position, or the start of the race
    }
    
    //Accessor method - returns current position of tortoise
    public int getPosition(){
        return position;
    }
    
    //Mutator method - sets current position to arg (private to ensure only way to change pos is to use fastPlod(), slowPlod(), and slip())
    private void setPosition(int position){
        //If-else construct to validate arg
        if (position >= MIN_POSITION && position <= maxPosition){
            this.position = position; //Sets position to arg if arg within min and max limits
        }
        else if (position < MIN_POSITION){
            this.position = MIN_POSITION; //Sets position to min position if arg less than min position
        }
        else{
            this.position = maxPosition; //Sets position to max position if arg more than min position
        }
    }
    
    //Accessor method - returns max position
    public int getMaxPosition(){
        return maxPosition;
    }
    
    //Mutator method - sets max position to arg
    public void setMaxPosition(int maxPosition){
        //If-else construct validates arg
        if (maxPosition >= MIN_POSITION){
            this.maxPosition = maxPosition; //Sets max position to arg if arg greater than min position
        }
        else{ 
            System.out.println("Invalid maximum position!!!"); //Display error if arg less than min position
        }
    }
    
    //Method to represent fast plod of tortoise
    public void fastPlod(){
        setPosition(position + FAST_PLOD); //Set position to after a fast plod
    }
    
    //Method to represent slow plod of tortoise
    public void slowPlod(){
        setPosition(position + SLOW_PLOD); //Set position to after a slow plod
    }
    
    //Method to represent slip of tortoise
    public void slip(){
        setPosition(position + SLIP); //Set position to after a slip
    }
    
     //Method to move the tortoise. Takes in tortoise obj and the random-generated #
    public void moveTortoise(int randomNumber){
        //Use switch statements depending on rand #
        switch (randomNumber){
            //If rand # is b/w 1-5, then tortoise does fastPlod()
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                fastPlod();
                break;
            //If rand # is b/w 6-8, then tortoise does slowPlod()
            case 6:
            case 7:
            case 8:
                slowPlod();
                break;
            //If rand # is 9 or 10, then tortoise does slip()
            case 9:
            case 10:
                slip();
                break;
        }
    }
}
    

