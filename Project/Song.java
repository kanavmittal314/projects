//Define package and class
package Project;
public class Song {
    
    //Data fields for title, artist, and price
    private String title;
    private String artist;
    private double price;
    
    //No-arg constructor sets title and artist to empty Strings and price to 0.0
    public Song(){
        setTitle("");
        setArtist("");
        setPrice(0.0);
    }
    
    //Parameterized constructor sets data fields to args
    public Song(String title, String artist, double price){
        setTitle(title);
        setArtist(artist);
        setPrice(price);
        
    }
    
    //Accessor method for title
    public String getTitle(){
        return title;
    }
    
    //Accessor method for artist
    public String getArtist(){
        return artist;
    }
    
    //Accessor method for price
    public double getPrice(){
        return price;
    }
    
    //Mutator method for title
    public void setTitle(String title){
        this.title = title;
    }
    
    //Mutator method for artist
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    //Mutator method for price
    public void setPrice(double price){
        //Ensure price is non-negative
        if (price >= 0){
            this.price = price;
        }
        else{
            System.out.println("Error!");
        }
    }
}