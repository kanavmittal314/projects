//Define package and interface
package Assignment5;
public interface SongReader {
    
    //Abstract method to read songs given the text file, will return array of songs inside file
    Song[] readSong(String textFile);
}
