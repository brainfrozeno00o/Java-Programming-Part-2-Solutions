package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application{

    @Override
    public void start(Stage window){
        Button buttonComponent = new Button("Test Button");
        TextField textFieldComponent = new TextField("Test Text Field");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(textFieldComponent);
        componentGroup.getChildren().add(buttonComponent);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
