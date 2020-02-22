//Define package and class
package Assignment5;
public class Song {
    
    //Private data fields
    private String title;
    private String artist;
    private String genre;
    
    //No-parameter constructor sets all data fields to empty Strings
    public Song(){
        setTitle("");
        setArtist("");
        setGenre("");
    }
    
    //Parameterized constructor sets all data fields to arguments
    public Song(String title, String artist, String genre){
        setTitle(title);
        setArtist(artist);
        setGenre(genre);
    }
     
    //Accessor method for title
    public String getTitle(){
        return title;
    }
    
    //Accessor method for artist
    public String getArtist(){
        return artist;
    }
    
    //Accessor method for genre
    public String getGenre(){
        return genre;
    }
    
    //Mutator method for title
    public void setTitle(String title){
        this.title = title;
    }
    
    //Mutator method for artist
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    //Mutator method for genre
    public void setGenre(String genre){
        this.genre = genre;
    }

}
