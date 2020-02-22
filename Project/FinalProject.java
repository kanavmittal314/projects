package Project; //Define package

//Import JavaFX libraries
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList; //Import ArrayList


//Define class and superclass Application
public class FinalProject extends Application {
    
    //Constant array of Songs not to be modified by user
    public static final Song[] SONGS = {new Song("Janam Janam", "Arijit Singh", 1.99), 
                                        new Song("No Roots", "Alice Merton", 0.99), 
                                        new Song ("Shape of You", "Ed Sheeran", 3.99), 
                                        new Song ("New Rules", "Dua Lipa", 1.99), 
                                        new Song ("Despacito", "Luis Fonsi feat. Justin Bieber", 2.50)};
    
    //Override start method from Application
    @Override
    public void start(Stage stage){
        stage.setTitle("Shopping Cart and Checkout"); //Set appropriate title of stage
        GridPane rootNode = new GridPane(); //GridPane layout manager
        Scene scene = new Scene(rootNode, 2000, 1000); //Create scene 2000 by 1000 px
        
        //Set vertical gap of 10 px, horizontal gap of 20 px, and padding all around 30 px
        rootNode.setVgap(10);
        rootNode.setHgap(20);
        rootNode.setPadding(new Insets(30));
        
        //Create a User object for the current user
        User user = new User();
        
        //Create text field to input name and set appropriate prompt text
        TextField inputName = new TextField();
        inputName.setPromptText("Enter first and last name");
        
        //Create text field to input email and set appropriate prompt text
        TextField inputEmail = new TextField();
        inputEmail.setPromptText("Enter email");
        
        
        
        //Create combo box of the types of payment - Visa, MasterCard, Amex - with appropriate prompt text
        ObservableList<String> paymentList = FXCollections.observableArrayList(User.PAYMENT);
        ComboBox<String> inputPayment = new ComboBox<>(paymentList);
        inputPayment.setPromptText("Choose a payment method");
        
        //Labels to be used when confirm button clicked
        Label errorLabel = new Label("");
        Label welcome = new Label("");
        
        //Create a button to confirm the name, email, and payment
        Button userButton = new Button("Confirm");
        
        //Register action for confirmation button (for user information)
        userButton.setOnAction(new EventHandler<ActionEvent>(){
            
            //Override handle() from EventHandler<ActionEvent>
            @Override
            
            public void handle(ActionEvent e){

               //Boolean variables to hold whether error occurred in fields
               boolean errorName = false;
               boolean errorEmail = false;
               boolean errorPayment = false;
               
               //If user has not inputted valid name
                if(inputName.getText() == null || !user.setName(inputName.getText())){          
                    errorName = true; //Error has occurred
                }
                
                //If user has not inputted valid email
                if(inputEmail.getText() == null || !user.setEmail(inputEmail.getText())){
                    errorEmail = true; //Error has occurred
                }
                
                //If user has not inputted valid payment
                if(inputPayment.getValue() == null || !user.setPayment(inputPayment.getValue())){
                    errorPayment = true; //Error has occurred
                }
                
                //Initialize to empty Strings the error and welcome responses
                String welcomeResponse = "";
                String errorResponse = "";
                
                
                //If error in name, add info to errorResponse. Else, add user name to welcomeResponse
                if (errorName){
                    errorResponse += "Name, ";
                }
                else{
                    welcomeResponse += "Welcome, " + user.getName() + ".";
                }
                
                //If error in email, add info to errorResponse. Else, add user email to welcomeResponse
                if (errorEmail){
                    errorResponse += "Email, ";
                }
                else{
                    welcomeResponse += "\nHere is your email: " + user.getEmail();
                }
                
                //If error in payment, add info to errorResponse. Else, add user payment to welcomeResponse
                if (errorPayment){
                    errorResponse += "Payment, ";
                }
                else{
                    welcomeResponse += "\nHere is your payment method: " + user.getPayment();
                }
                
                //If error has occurred
                if (errorName || errorEmail || errorPayment){
                    //Add prefix message to errorResponse
                    errorResponse = "Sorry. There is an error in: " + errorResponse; 
                    //Take off last two characters
                    errorResponse = errorResponse.substring(0, errorResponse.length() - 2);
                }
                
                //Set errorResponse and welcomeResponse into corresponding labels
                errorLabel.setText(errorResponse);
                welcome.setText(welcomeResponse);
                  
            }
        });
        
        //Label to be used for the song ListView events
        Label songLabel = new Label("");
        
        //ArrayList to hold String of how songs should be displayed
        ArrayList<String> songs = new ArrayList<>();
        
        //Iterate through each song in constant array SONGS
        for (Song song : SONGS) {
            //Each song will be displayed by title, price in 2 dec places, and artist
            songs.add(song.getTitle() + " [$" + String.format("%.2f",song.getPrice()) + "] by " + song.getArtist());
        }
 
        //Create ListView songList of all the songs in "display format"
        ListView<String> songList = new ListView(FXCollections.observableArrayList(songs));
        //Multiple songs can be selected
        songList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        songList.setFocusTraversable(false); //Don't allow focusing becauses messes up with selections
        
        //ArrayList holds the selected songs
        ArrayList<Song> selectedSongs = new ArrayList<>();

        /* Originally tried ActionEvent for ListView but was giving problem 
        deselecting. Used MouseEvent instead for when user clicks on ListView */
        
        //Regiser mouse event
        songList.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            //Override handle() from EventHandler<MouseEvent>
            @Override
            public void handle(MouseEvent mouseEvent){
                
                String response = "  "; //Initialize response to 2 spaces
                selectedSongs.clear(); //Clear previous ArrayList of selections
                
                //Iterate through constant array of SONGS (which had ultimately formed the ListView)
                for (int i = 0; i < SONGS.length; i++){
                    //Check if corresponding element in ListView is selected
                    if(songList.getSelectionModel().isSelected(i)){
                        selectedSongs.add(SONGS[i]); //Add the corresponding song to selected songs
                        response += SONGS[i].getTitle() + ", "; //Add title of song to response
                    }
                }
                /*Set String response into label after removing final two 
                characters (either 2 spaces or comma and space)*/          
                songLabel.setText(response.substring(0, response.length()-2));
            }
        });
        
        //Create empty label that will hold information about price
        Label priceLabel = new Label("");
        //Create button for calculating price
        Button calculateButton = new Button("Calculate");
        //Register button with event
        calculateButton.setOnAction(new EventHandler<ActionEvent>(){
            
            //Override method from EventHandler<ActionEvent>
            @Override
            public void handle(ActionEvent actionEvent){
                double price = 0.0; //Initialize price to 0
                
                //Iterate through selected songs ArrayList and add price of each song to price variable
                for (Song song : selectedSongs){
                    price += song.getPrice();
                }
                
                //Format price with 2 decimal places and set into label on GUI
                String priceString = String.format("%.2f", price);
                priceLabel.setText("Price is $" + priceString + "");
            }
        });
        
        //Create button to exit application
        Button exitButton = new Button("Exit");
        //Register button with event
        exitButton.setOnAction(new EventHandler<ActionEvent>(){
            
            //Override handle() from EventHandler<ActionEvent>
            @Override
            public void handle(ActionEvent actionEvent){
                try{ //Try-catch for potential exceptions
                    stage.close(); //Close stage to terminate application
                }
                catch (Exception exception){ //Catch potential exception but don't do anything
                }
            }
        });
        
        //Add descriptive labels to GridPane rootNode
        rootNode.add(new Label("Name:    "), 0, 0); 
        rootNode.add(new Label("Email:   "), 0, 1); 
        rootNode.add(new Label("Payment: "), 0, 2); 
        rootNode.add(new Label("Songs:   "), 0, 3);
        rootNode.add(new Label("Your shopping cart contains: "), 0, 4);
        
        //Add text fields for name and email to GridPane rootNode
        rootNode.add(inputName, 1, 0);
        rootNode.add(inputEmail, 1, 1);
        //Add combo box to GridPane rootNode
        rootNode.add(inputPayment, 1, 2);
        
        //Add label to display user info error to GridPane rootNode
        rootNode.add(errorLabel, 2, 0);
        //Add button to confirm user info to GridPane rootNode
        rootNode.add(userButton, 2, 1);
        //Add label to display welcome message to GridPane rootNode
        rootNode.add(welcome, 2, 2);
        
        //Add ListView of songs to GridPane rootNode
        rootNode.add(songList, 1, 3);
        //Add label of songs selected to GridPane rootNode
        rootNode.add(songLabel, 1, 4);
        //Add button to calculate to GridPane rootNode
        rootNode.add(calculateButton, 0, 5);
        //Add label to display price to GridPane rootNode
        rootNode.add(priceLabel, 1, 5);
        
        //Add button to exit application to GridPane rootNode
        rootNode.add(exitButton, 0, 6);
        
        //Set scene onto stage and show stage
        stage.setScene(scene);
        stage.show();   
    }
    
    //Main method calls launch() from Application
    public static void main(String[] args){
        launch(args);
    }
}