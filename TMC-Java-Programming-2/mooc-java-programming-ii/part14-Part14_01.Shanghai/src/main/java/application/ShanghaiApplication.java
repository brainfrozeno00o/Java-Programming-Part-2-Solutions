package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{

    @Override
    public void start(Stage stage){
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        XYChart.Series series = new XYChart.Series();
        //series.setName("University of Helsinki, Shanghai rankings");
        
        series.getData().add(new XYChart.Data(2007, 73));
        series.getData().add(new XYChart.Data(2008, 68));
        series.getData().add(new XYChart.Data(2009, 72));
        series.getData().add(new XYChart.Data(2010, 72));
        series.getData().add(new XYChart.Data(2011, 74));
        series.getData().add(new XYChart.Data(2012, 73));
        series.getData().add(new XYChart.Data(2013, 76));
        series.getData().add(new XYChart.Data(2014, 73));
        series.getData().add(new XYChart.Data(2015, 67));
        series.getData().add(new XYChart.Data(2016, 56));
        series.getData().add(new XYChart.Data(2017, 56));
        
        lineChart.getData().add(series);
        
        Scene scene = new Scene(lineChart, 640, 480);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
