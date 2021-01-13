package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application{

    @Override
    public void start(Stage stage){
        
        Canvas paintingCanvas = new Canvas(400, 400);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        
        painter.setFill(Color.BLACK);
        painter.fillRect(100, 50, 52, 52); //right eye
        painter.fillRect(250, 50, 52, 52); //left eye
        painter.fillRect(48, 200, 52, 52); //right dimple
        painter.fillRect(302, 200, 52, 52); //left dimple
        painter.fillRect(100, 252, 202, 52); //smile
        
        Scene view = new Scene(paintingLayout);
        
        stage.setScene(view);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
