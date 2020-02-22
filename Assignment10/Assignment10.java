package Assignment10; //Define package

//Import javaFX libraries
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

//Define class and super class Application
public class Assignment10 extends Application {
    
    //Override start() method from Application
    @Override
    public void start(Stage stage){
        
        stage.setTitle("Loan Calculator"); //Set appropriate title to stage
        
        GridPane rootNode = new GridPane(); //Use grid pane layout manager for root node
        
        //Set padding all around to 30 px and horizontal/vertical gap to 5 px
        rootNode.setPadding(new Insets(30)); 
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        
        //Create scene with grid pane rootNode and set to 300 * 200 px, set the scene onto stage
        Scene scene = new Scene (rootNode, 300, 200);
        stage.setScene(scene);
        
        //Use grid pane add() method to add appropriate labels vertically in left column
        rootNode.add(new Label("Annual Interest Rate: "), 0, 0);
        rootNode.add(new Label("Number of Years:      "), 0, 1);
        rootNode.add(new Label("Loan Amount:          "), 0, 2);
        rootNode.add(new Label("Monthly Payment:      "), 0, 3);
        rootNode.add(new Label("Total Payment:        "), 0, 4);
        
        //Use grid pane add() method to add appropriate text fields vertically in right column
        rootNode.add(new TextField(), 1, 0);
        rootNode.add(new TextField(), 1, 1);
        rootNode.add(new TextField(), 1, 2);
        rootNode.add(new TextField(), 1, 3);
        rootNode.add(new TextField(), 1, 4);
        
        //Create button for calculations and add to bottom right coordinate
        Button button = new Button("Calculate");
        rootNode.add(button, 1, 5);
        rootNode.setHalignment(button, HPos.RIGHT); //Right-align the button
        
        stage.show(); //Show the stage
    }
    
    //Main method launches the JavaFX
    public static void main(String[] args){
        launch(args);
    }
}