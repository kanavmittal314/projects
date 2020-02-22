//Define package and class
package Assignment5;
public class Assignment5 {
    
    //Global variable for the songs entered so far
    protected static int songsEntered = 0;
    
    //Define main method
    public static void main(String[] args){     
        
        String textFile = getTextFile(); //Input text file
        
        //Initialize user's choice to 0
        int userChoice = 0;
        
        //Loop through until user chooses 3, or quit
        while (userChoice != 3){
            userChoice = getUserChoice();  //Input user choice
            
            //Switch structure based on user's choice
            switch (userChoice){
                
                //Add song to given text file if user chooses 1
                case 1: addSong(textFile); break;
                
                //Display songs of text file if user chooses 2
                case 2: displaySongs(textFile); break;
                
                //Do nothing if user chooses 3
                case 3: break;
            }
                
        }
    }
    
    //Input text file from user using Input.getString()
    public static String getTextFile(){
        return Input.getString("What is the name of the text file? Please add .txt file extension: ");
    }
    
    //Input choice of user using Input.getInt()
    public static int getUserChoice(){
        return Input.getInt("Enter 1 to add a song, 2 to display all songs, or 3 to quit the program: ");
    }
    
    //Add song to given text file
    public static void addSong(String textFile){
        
        //Input from user how many songs to add
        int numberOfSongs = Input.getInt("How many songs would you like to add? ");
        
        //Array of Songs with size of that number of songs
        Song[] songArray = new Song[numberOfSongs];
        
        //Process through array
        for (int i = 0; i < numberOfSongs; i++){
            songsEntered += 1; //Increase songsEntered as song is being entered
            String appendange = " of Song " + songsEntered + "?"; //Common appendange for all user prompts
            //Each element of the array is a new Song given the arguments from user prompts
            songArray[i] = new Song(Input.getString("What is the title" + appendange), Input.getString("Who is the artist" + appendange), Input.getString("What is the genre" + appendange));
        }
        //Create a new SongTextFileProcessor because need to use instance methods
        SongTextFileProcessor songTextFileProcessor = new SongTextFileProcessor();
        
        //Write to the song given the textFile argument and the songArray formed from user prompting
        songTextFileProcessor.writeSong(textFile, songArray);
        
        //Display confirmation that song(s) added
        if (numberOfSongs == 1){
            System.out.println("Song added!");
        }
        else{
            System.out.println("Songs added!");
        }
    }
    
    //Display songs from given text file
    public static void displaySongs(String textFile){
        //Create a new SongTextFileProcessor because need to use instance methods
        SongTextFileProcessor songTextFileProcessor = new SongTextFileProcessor();
        
        //Create Song array formed by return Song[] of readSong()
        Song[] songArray = songTextFileProcessor.readSong(textFile);
        
        //Process through songArray
        for (int i = 0; i < songArray.length; i++){
            
            //Print out on a new line the title, artist, genre of each song
            System.out.println("Song " + (i+1) + ": " + songArray[i].getTitle() + " is by " + songArray[i].getArtist() + " in the genre of " + songArray[i].getGenre());
        }
    }
}