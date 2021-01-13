package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

public class MultipleViews extends Application{

    @Override
    public void start(Stage window){
        BorderPane borderLayout = new BorderPane();
        Label firstViewLabel = new Label("First view!");
        Button secondViewButton = new Button("To the second view!");
        
        borderLayout.setTop(firstViewLabel);
        borderLayout.setCenter(secondViewButton);
        
        Scene firstView = new Scene(borderLayout);
        
        VBox vboxLayout = new VBox();
        Button thirdViewButton = new Button("To the third view!");
        Label secondViewLabel = new Label("Second view!");
        
        vboxLayout.getChildren().add(thirdViewButton);
        vboxLayout.getChildren().add(secondViewLabel);
        
        Scene secondView = new Scene(vboxLayout);
        
        GridPane gridPaneLayout = new GridPane();
        Button firstViewButton = new Button("To the first view!");
        Label thirdViewLabel = new Label("Third view!");
        
        gridPaneLayout.add(thirdViewLabel, 0, 0);
        gridPaneLayout.add(firstViewButton, 1, 1);
        
        Scene thirdView = new Scene(gridPaneLayout);
        
        secondViewButton.setOnAction((event) -> {
            window.setScene(secondView);
        });
        
        thirdViewButton.setOnAction((event) -> {
            window.setScene(thirdView);
        });
        
        firstViewButton.setOnAction((event) -> {
            window.setScene(firstView);
        });
        
        window.setScene(firstView);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}
