package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application{

    @Override
    public void start(Stage window){
        TextField topText = new TextField();
        Button button = new Button("Update");
        Label bottomLabel = new Label("");
        
        button.setOnAction((event) -> {
            bottomLabel.setText(topText.getText());
        });
        
        VBox componentGroup = new VBox();
        //componentGroup.setSpacing(10);
        componentGroup.getChildren().addAll(topText, button, bottomLabel);
        
        Scene scene = new Scene(componentGroup);
        
        window.setScene(scene);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
