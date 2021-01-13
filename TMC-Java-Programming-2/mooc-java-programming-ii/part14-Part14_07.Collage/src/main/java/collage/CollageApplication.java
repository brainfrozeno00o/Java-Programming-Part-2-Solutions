package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");
        
        PixelReader pixels = sourceImage.getPixelReader();
                        
        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();
        
        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter writer = targetImage.getPixelWriter();
        
        for (int y = 0; y < height/2; ++y){
            for(int x = 0; x < width/2; ++x){
                Color pixelColor = pixels.getColor(x * 2, y * 2);
                double red = 1.0 - pixelColor.getRed();
                double green = 1.0 - pixelColor.getGreen();
                double blue = 1.0 - pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();
                
                Color newColor = new Color(red, green, blue, opacity);
                
                
                writer.setColor(x, y, newColor);
            }
        }
        
        for(int y = 0; y < height/2; ++y){
            for(int x = width/2; x < width; ++x){
                Color pixelColor = pixels.getColor((x - (width/2)) * 2, y * 2);
                double red = 1.0 - pixelColor.getRed();
                double green = 1.0 - pixelColor.getGreen();
                double blue = 1.0 - pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();
                
                Color newColor = new Color(red, green, blue, opacity);
                                
                writer.setColor(x, y, newColor);                
            }
        }
        
        for(int y = height/2; y < height; ++y){
            for(int x = 0; x < width/2; ++x){
                Color pixelColor = pixels.getColor(x * 2, (y - (height / 2)) * 2);
                double red = 1.0 - pixelColor.getRed();
                double green = 1.0 - pixelColor.getGreen();
                double blue = 1.0 - pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();
                
                Color newColor = new Color(red, green, blue, opacity);
                                
                writer.setColor(x, y, newColor);                
            }
        }
        
        for(int y = height/2; y < height; ++y){
            for(int x = width/2; x < width; ++x){
                Color pixelColor = pixels.getColor((x - (width/2)) * 2, (y - (height / 2)) * 2);
                double red = 1.0 - pixelColor.getRed();
                double green = 1.0 - pixelColor.getGreen();
                double blue = 1.0 - pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();
                
                Color newColor = new Color(red, green, blue, opacity);
                                
                writer.setColor(x, y, newColor);                
            }
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
