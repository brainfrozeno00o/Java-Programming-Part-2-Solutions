package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application{
    
    @Override
    public void start(Stage stage){
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        ArrayList<String[]> data = getTSV(new File("partiesdata.tsv"));
        
        XYChart.Series kok = new XYChart.Series();
        kok.setName("KOK");
        
        for (int i = 1; i < data.get(0).length; ++i){
            kok.getData().add(new XYChart.Data(Integer.valueOf(data.get(0)[i]), Double.valueOf(data.get(1)[i])));
        }
        
        lineChart.getData().add(kok);
        
        XYChart.Series sdp = new XYChart.Series();
        sdp.setName("SDP");
        
        for (int i = 1; i < data.get(0).length; ++i){
            sdp.getData().add(new XYChart.Data(Integer.valueOf(data.get(0)[i]), Double.valueOf(data.get(2)[i])));
        }
        
        lineChart.getData().add(sdp);
        
        XYChart.Series kesk = new XYChart.Series();
        kesk.setName("KESK");
        
        for (int i = 1; i < data.get(0).length; ++i){
            kesk.getData().add(new XYChart.Data(Integer.valueOf(data.get(0)[i]), Double.valueOf(data.get(3)[i])));
        }
        
        lineChart.getData().add(kesk);
        
        XYChart.Series vihr = new XYChart.Series();
        vihr.setName("VIHR");
        
        for (int i = 1; i < data.get(0).length; ++i){
            if (!data.get(4)[i].equals("-")) {
                vihr.getData().add(new XYChart.Data(Integer.valueOf(data.get(0)[i]), Double.valueOf(data.get(4)[i])));
            }
        }
        
        lineChart.getData().add(vihr);
        
        XYChart.Series vas = new XYChart.Series();
        vas.setName("VAS");
        
        for (int i = 1; i < data.get(0).length; ++i){
            vas.getData().add(new XYChart.Data(Integer.valueOf(data.get(0)[i]), Double.valueOf(data.get(5)[i])));
        }
        
        lineChart.getData().add(vas);
        
        XYChart.Series ps = new XYChart.Series();
        ps.setName("PS");
        
        for (int i = 1; i < data.get(0).length; ++i){
            ps.getData().add(new XYChart.Data(Integer.valueOf(data.get(0)[i]), Double.valueOf(data.get(6)[i])));
        }
        
        lineChart.getData().add(ps);
        
        XYChart.Series rkp = new XYChart.Series();
        rkp.setName("RKP");
        
        for (int i = 1; i < data.get(0).length; ++i){
            rkp.getData().add(new XYChart.Data(Integer.valueOf(data.get(0)[i]), Double.valueOf(data.get(7)[i])));
        }
        
        lineChart.getData().add(rkp);
        
        Scene scene = new Scene(lineChart, 640, 480);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static ArrayList<String[]> getTSV(File file){
        ArrayList<String[]> data = new ArrayList<>();
        
        try (BufferedReader tsvReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = tsvReader.readLine()) != null) {
                String[] lineItems = line.split("\t");
                data.add(lineItems);
            }
        } catch (Exception e) {
            System.out.println("There is a problem reading the .tsv file.");
        }
        
        return data;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
