package Project2;

//Create class for square objects
public class Square{
    //Declare private String data field to hold the contents of a square
    private String contents;
    
    //Constructor for a Square object
    public Square(){
        contents = "-"; //Sets contents to a simple hyphen
    }
    
    //Mutator method - sets contents of square to arg
    public void setContents(String contents){
        this.contents = contents;
    }
    
    //Accessor method - returns contents of square
    public String getContents(){
        return contents;
    }
    
}
