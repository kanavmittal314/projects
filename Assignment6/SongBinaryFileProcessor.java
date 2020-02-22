//Define package
package Assignment6;

//Import libraries
import java.io.*;
import java.util.*;

//Define class and interface implementations
public class SongBinaryFileProcessor implements SongReader, SongWriter {
    
    //Data field for the "delimiter", or what is used to separate data entries
    private int delimiter;
    
    //No-parameter constructor sets delimiter to integer 0
    public SongBinaryFileProcessor(){
        setDelimiter(0);
    }
    
    //Parameterized constructor sets delimeter to argument
    public SongBinaryFileProcessor(int delimiter){
        setDelimiter(delimiter);
    }
    
    //Accessor method for delimiter
    public int getDelimiter(){
        return delimiter;
    }
    
    //Mutator method for delimiter
    public void setDelimiter(int delimiter){
        this.delimiter = delimiter;
    }
   
    //Implementation for readSong() from SongReader
    @Override
    public Song[] readSong (String binaryFile){
        
        //Create new empty ArrayList of Song objects
        ArrayList<Song> songs = new ArrayList<>(0);
        
        //Try-catch to account for possible exceptions, use resources to create input stream
        try(DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(binaryFile)))){
            
            //While-loop to process through entire input stream
            while (input.available() > 0){
                
                String title = input.readUTF(); //First string is the title
                input.readInt(); //Integer after is a delimiter
                String artist = input.readUTF(); //Second string is the artist
                input.readInt(); //Integer after is a delimiter
                String genre = input.readUTF(); //Third string is the genre
                input.readInt(); //Final integer is delimiter
                
                //Create new song with the Strings from the input stream and add song to ArrayList songs
                songs.add(new Song(title, artist, genre));
            }
            input.close(); //Close input stream
        }
        
        //Display error message if exception caught
        catch(Exception exception){
            System.out.println("Exception read");
        }
        
        //Convert ArrayList songs to array of type Song and return Song[]
        return songs.toArray(new Song[songs.size()]);
    }
    
    //Implementation for writeSong() from SongWriter
    @Override
    public void writeSong (String binaryFile, Song[] songs){
        
        //Try-catch to account for possible exceptions, use resources to create output stream
        try(DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(binaryFile,true)))){
            
            //For-loop to process through entire array of Song
            for (int i = 0; i < songs.length; i++){
                output.writeUTF(songs[i].getTitle()); //Write the title of the song as a String
                output.writeInt(delimiter); //Separate with delimiter integer
                output.writeUTF(songs[i].getArtist()); //Write the artist as a String
                output.writeInt(delimiter); //Separate with delimiter integer
                output.writeUTF(songs[i].getGenre()); //Write the genre as a String
                output.writeInt(delimiter); //Separate with delimiter integer
            }
            output.close(); //Close output stream
        }
        //Display error message if exception caught
        catch(Exception exception){
            System.out.println("Exception write");
        }
    }
}