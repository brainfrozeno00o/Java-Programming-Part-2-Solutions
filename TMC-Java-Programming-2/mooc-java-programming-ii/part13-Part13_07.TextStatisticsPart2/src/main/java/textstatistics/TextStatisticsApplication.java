package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");
        
        TextArea text = new TextArea("");
        
        HBox labels = new HBox();
        labels.setSpacing(10);
        labels.getChildren().add(letters);
        labels.getChildren().add(words);
        labels.getChildren().add(longestWord);
        
        layout.setBottom(labels);
        layout.setCenter(text);
        
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int numberOfWords = parts.length;            
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            letters.setText("Letters: " + characters);
            words.setText("Words: " + numberOfWords);
            longestWord.setText("The longest word is: " + longest);
        });
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
