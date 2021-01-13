package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.beans.value.ObservableValue;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane mainLayout = new BorderPane();
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Savings Counter");
        lineChart.setLegendVisible(false);
        
        VBox topLayer = new VBox();
        topLayer.setSpacing(10);
        
        BorderPane firstSlider = new BorderPane();
        Label monthlySavingsLabel = new Label("Monthly savings");
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        Label monthlySavingsValue = new Label("25");
        
        XYChart.Series monthlySavingSeries = new XYChart.Series();
        for(int i = 0; i <= (int) xAxis.getUpperBound(); ++i){
            monthlySavingSeries.getData().add(new XYChart.Data(i, ((int) monthlySavingsSlider.getValue() * i * 12)));
        }
        lineChart.getData().add(monthlySavingSeries);
        
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            monthlySavingsValue.setText(String.format("%.1f", new_val));
            lineChart.setAnimated(false);
            monthlySavingSeries.getData().clear();
            for(int i = 0; i <= (int) xAxis.getUpperBound(); ++i){
                monthlySavingSeries.getData().add(new XYChart.Data(i, (new_val.intValue() * i * 12)));
            }
            lineChart.setAnimated(true);
        });
                
        firstSlider.setLeft(monthlySavingsLabel);
        firstSlider.setCenter(monthlySavingsSlider);
        firstSlider.setRight(monthlySavingsValue);
        
        BorderPane secondSlider = new BorderPane();
        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Slider yearlyInterestRateSlider = new Slider(0, 10, 0);
        Label yearlyInterestRateValue = new Label("0");
        
        XYChart.Series yearlyInterestRateValueSeries = new XYChart.Series();
        
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            yearlyInterestRateValue.setText(String.format("%.1f", new_val));
            lineChart.setAnimated(false);
            yearlyInterestRateValueSeries.getData().clear();
            double previousInterest = 0.0;
            for(int i = 0; i <= (int) xAxis.getUpperBound(); ++i){
                double currentSavings =  i * monthlySavingsSlider.getValue() * 12;
                double savingsInterest = currentSavings * (new_val.doubleValue() / 100.0);
                double currentFinalInterest = currentSavings + savingsInterest + previousInterest;
                yearlyInterestRateValueSeries.getData().add(new XYChart.Data(i, (currentFinalInterest)));
                previousInterest += currentFinalInterest * (new_val.doubleValue() / 100.0);
            }
            lineChart.setAnimated(true);
        });
        
        lineChart.getData().add(yearlyInterestRateValueSeries);
        
        secondSlider.setLeft(yearlyInterestRateLabel);
        secondSlider.setCenter(yearlyInterestRateSlider);
        secondSlider.setRight(yearlyInterestRateValue);
        
        topLayer.getChildren().addAll(firstSlider, secondSlider);
        
        mainLayout.setTop(topLayer);
        mainLayout.setCenter(lineChart);
        
        mainLayout.setPadding(new Insets(10, 10, 10, 10));
        
        Scene scene = new Scene(mainLayout);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
