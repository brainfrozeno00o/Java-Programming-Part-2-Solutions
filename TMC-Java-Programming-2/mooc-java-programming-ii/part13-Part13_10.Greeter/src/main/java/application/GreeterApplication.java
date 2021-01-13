package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{

    @Override
    public void start(Stage window){
        Label nameNotif = new Label("Enter your name and start.");
        TextField nameTextField = new TextField("");
        Button startButton = new Button("Start");
        
        GridPane layout = new GridPane();
        
        layout.add(nameNotif, 0, 0);
        layout.add(nameTextField, 0, 1);
        layout.add(startButton, 0, 2);
        
        layout.setPrefSize(300, 100);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene firstView = new Scene(layout);
        
        Label welcomeText = new Label("Welcome ");
        
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 100);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        Scene secondView = new Scene(welcomeLayout);
        
        startButton.setOnAction((event) -> {
            String name = nameTextField.getText();
            welcomeText.setText("Welcome " + name + "!");
            window.setScene(secondView);
        });
        
        window.setScene(firstView);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
