/*Kanav Mittal 1234907, Aug 17 2017
Project 2, Finishing Up */

package Project2;

import java.util.Scanner; //Import Scanner library

//Set driver class and main method
public class Project2 {
    public static void main(String[] args){
        
        //Declare and initialize number of squares to return value of getNumberOfSquares(). Represents race length.
        int numberOfSquares = getNumberOfSquares();
        
        //Create tortoise and hare objects using constructors.
        Tortoise tortoise = new Tortoise(numberOfSquares);
        Hare hare = new Hare(numberOfSquares);
        
        //Display starting message
        System.out.println("\nAND THEY'RE OFF!!\n");
        
        //Use a while loop to continue looping until a winner emerges
        while (true){
            //Array of Square objects
            Square[] squareArray = new Square[numberOfSquares]; //Declare and create squareArray
            
            //Use for loop to iterate through array
            for (int i = 0; i < numberOfSquares; i++){
                squareArray[i] = new Square(); //Use constructor to initialize each element of array
            }
            
            //Declare and initialize int var to return value from getRandomNumber()
            int randomNumber = getRandomNumber();
            
            //Use methods to move tortoise and hare depending on rand #
            tortoise.moveTortoise(randomNumber);
            hare.moveHare(randomNumber);
            
            //Display tortoise and hare position using getPosition()
            System.out.println("Tortoise position: " + tortoise.getPosition());
            System.out.println("Hare position: " + hare.getPosition());
            
            
            //Use if-else construct to display positions of hare and tortoise
            if (tortoise.getPosition() == hare.getPosition()){
                squareArray[tortoise.getPosition()-1].setContents("OUCH! TH!"); //If tortoise position = hare position, then set contents of corr Square obj to String
            }
            else{ //If tortoise and hare on diff pos
                squareArray[tortoise.getPosition()-1].setContents("T"); //Set contents of corr Square obj to String
                squareArray[hare.getPosition()-1].setContents("H"); //Set contents of corr Square obj to String
            }
            
            displayArray(squareArray); //Display the array
            
            //Use if-else constructs to determine the outcome; break from loop if any of winning outcomes true, otherwise continue loop
            if (tortoise.getPosition() >= numberOfSquares && hare.getPosition() >= numberOfSquares){
                tie(); //Race is tie if both tortoise and hare position = end of race
                break;
            }
            else if (tortoise.getPosition() >= numberOfSquares){
                tortoiseWin(); //Tortoise wins if only tortoise pos = end of race
                break;
            }
            else if (hare.getPosition() >= numberOfSquares){
                hareWin(); //Hare wins if only hare pos = end of race
                break;
            }
        }
        
    }
    
    //Method that inputs and returns # of squares
    public static int getNumberOfSquares(){
        System.out.println("Enter the number of squares you would like the length of the race to be: "); //Display prompt
        Scanner input = new Scanner(System.in); //Create Scanner object
        int numberOfSquares = input.nextInt(); //Read input and store in int var
        return numberOfSquares; //Return # of squares
    }
    
    //Method that generates and returns random number
    public static int getRandomNumber(){
        int randomNumber = (int)(Math.random() * 10) + 1; //Use Math.Random() to generate b/w 0 and 1. Multiply by 10 to generate b/w 0 and 9. Convert to int for only integers b/w 0 and 9. Add 1 for 1-10
        return randomNumber; //Return the random number
    }
    
    //Method for if race ends in tie
    public static void tie(){
        System.out.println("IT'S A TIE!!"); //Display tie outcome 
    }
    
    //Method for if race ends in a tortoise victory
    public static void tortoiseWin(){
        System.out.println("TORTOISE WINS!!"); //Display tortoise winning outcome
    }
    
    //Method for if race ends in a hare victory
    public static void hareWin(){
        System.out.println("HARE WINS!!"); //Display hare winning outcome
    }
    
    //Method for displaying the Square[] (arg)
    public static void displayArray(Square[] squareArray){
        //Use for loop to iterate through array
        for (int i = 0; i < squareArray.length; i++){
            //Print out vertical bars to distinguish each square and the contents of the square
            System.out.print(" |" + squareArray[i].getContents() + "| ");
        }
        System.out.println("\n"); //Print out a new line to distinguish between each round
    }
}