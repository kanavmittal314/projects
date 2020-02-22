//Define package
package Assignment5;

//Import libraries
import java.io.*;
import java.util.*;

//Define class
public class SongTextFileProcessor implements SongReader, SongWriter {
    
    //Data field for the delimiter
    private String delimiter;
    
    //No-parameter constructor sets delimiter to ":", the delimiter used in Assignment5.java
    public SongTextFileProcessor(){
        setDelimiter(":");
    }
    
    //Parameter constructor sets delimiter to argument
    public SongTextFileProcessor(String delimiter){
        setDelimiter(delimiter);
    }
    
    //Accessor method for delimiter
    public String getDelimiter(){
        return delimiter;
    }
    
    //Mutator method for delimiter
    public void setDelimiter(String delimiter){
        this.delimiter = delimiter;
    }
    
    //Implementation of readSong method from SongReader
    @Override
    public Song[] readSong(String textFile){
        
        //Creates ArrayList of size 0 to store the songs read
        ArrayList<Song> songArray = new ArrayList<>(0);
        
        /* Try-catch to account for potential IOExceptions and other exceptions
        Use resources in try to create new BufferedReader from argument textFile */
        try (BufferedReader input = new BufferedReader(new FileReader(textFile))){
            
            //Declare the currentLine and currentSong working on
            String currentLine;
            Song currentSong;
            
            //While-loop processes through all non-empty lines of the text file
            while ((currentLine = input.readLine())!= null){
                
                //Create scanner for the current line using specified delimiter
                Scanner scanner = new Scanner (currentLine);
                scanner.useDelimiter(delimiter);
                
                //Create new song by scanning for the title, artist, and genre and add song to songArray
                currentSong = new Song(scanner.next(),scanner.next(),scanner.next());
                songArray.add(currentSong);
                
                scanner.close(); //Close scanner
            }
            input.close(); //Close input stream
        }
        
        //Display error message for IOException
        catch (IOException ioException){
            System.out.println("Error i/o read");
        }
        
        //Display error message for other exceptions
        catch (Exception exception){
            System.out.println("Other error read");
        }
        
        //Returns a Song[] formed from the ArrayList songArray
        return songArray.toArray(new Song[songArray.size()]);
    }
    
    //Implementation for writeSong from SongWriter
    @Override
    public void writeSong(String textFile, Song[] song){
        
        /*Try-catch to account for possible IOExceptions and other exceptions
        Use resources in try to create new PrintWriter from argument textFile */
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(textFile, true)))){
            
            //Enhanced for-loop to process through song (Song[])
            for (Song currentSong : song) {
                
                //For each song element, print out the title, artist, and genre separated by delimiters
                output.print(currentSong.getTitle() + delimiter + currentSong.getArtist() + delimiter + currentSong.getGenre() + delimiter);
                output.println(); //Go to new line after each song element
            }   
            output.close(); //Close output stream
        }
        
        //Display error message for IOException
        catch (IOException ioException){
            System.out.println("Error i/o write");
        }
        
        //Display error message for other exceptions
        catch (Exception exception){
            System.out.println("Other error write");
        }
    }
}