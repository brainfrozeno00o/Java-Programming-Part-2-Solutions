package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application{

    @Override
    public void start(Stage stage){
        BorderPane uiLayout = new BorderPane();
        
        Label turnLabel = new Label("Turn: X");
        turnLabel.setFont(Font.font("Monospaced", 40));
        
        uiLayout.setTop(turnLabel);
        
        GridPane gridLayout = new GridPane();
        
        Button[] buttons = new Button[9];
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new Button(" ");
            buttons[i].setFont(Font.font("Monospaced", 40));
            
            Button currentButton = buttons[i];
            
            buttons[i].setOnMouseClicked((event) -> {

                    if (currentButton.getText().equals(" ")){
                        currentButton.setText(turnLabel.getText().substring(turnLabel.getText().length() - 1));
                        boolean checkGame = isGameOver(buttons);
                        if (checkGame) {
                            turnLabel.setText("The end!");
                        } else {
                            if (turnLabel.getText().substring(turnLabel.getText().length() - 1).equalsIgnoreCase("X")) {
                                turnLabel.setText("Turn: O");
                            } else {
                                turnLabel.setText("Turn: X");
                            }                            
                        }
                    }                     
                                                   
            }); 
        }
        
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j){
                gridLayout.add(buttons[(i * 3) + j], i, j);
            }
        }
        
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        gridLayout.setPadding(new Insets(10, 10, 10, 10));
        
        uiLayout.setCenter(gridLayout);
        
        Scene ui = new Scene(uiLayout);
                
        stage.setScene(ui);
        stage.show();
    }
    
    public static boolean isGameOver(Button[] buttons){
        String[] arrayText = new String[9];
        
        for (int i = 0; i < buttons.length; ++i){
            arrayText[i] = buttons[i].getText();
        }
        
        if((arrayText[0].equals(arrayText[1]) && arrayText[1].equals(arrayText[2]) && !arrayText[0].equals(" ") && !arrayText[1].equals(" ") && !arrayText[2].equals(" ")) ||
                (arrayText[3].equals(arrayText[4]) && arrayText[4].equals(arrayText[5]) && !arrayText[3].equals(" ") && !arrayText[4].equals(" ") && !arrayText[5].equals(" ")) ||
                (arrayText[6].equals(arrayText[7]) && arrayText[7].equals(arrayText[8]) && !arrayText[6].equals(" ") && !arrayText[7].equals(" ") && !arrayText[8].equals(" ")) ||
                (arrayText[0].equals(arrayText[3]) && arrayText[3].equals(arrayText[6]) && !arrayText[0].equals(" ") && !arrayText[3].equals(" ") && !arrayText[6].equals(" ")) ||
                (arrayText[1].equals(arrayText[4]) && arrayText[4].equals(arrayText[7]) && !arrayText[1].equals(" ") && !arrayText[4].equals(" ") && !arrayText[7].equals(" ")) ||
                (arrayText[2].equals(arrayText[5]) && arrayText[5].equals(arrayText[8]) && !arrayText[2].equals(" ") && !arrayText[5].equals(" ") && !arrayText[8].equals(" ")) ||
                (arrayText[0].equals(arrayText[4]) && arrayText[4].equals(arrayText[8]) && !arrayText[0].equals(" ") && !arrayText[4].equals(" ") && !arrayText[8].equals(" ")) ||
                (arrayText[2].equals(arrayText[4]) && arrayText[4].equals(arrayText[6]) && !arrayText[2].equals(" ") && !arrayText[4].equals(" ") && !arrayText[6].equals(" "))) {
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
