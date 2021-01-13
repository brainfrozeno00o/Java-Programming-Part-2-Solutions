/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author john.lingad
 */
public class AverageSensor implements Sensor {
    //private boolean sensorState;
    private ArrayList sensors;
    private List readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    @Override
    public boolean isOn(){
        for(Object s : this.sensors) {
            Sensor check = (Sensor) s;
            if (!check.isOn()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void setOn(){
        for(Object s : this.sensors) {
            Sensor setToOn = (Sensor) s;
            setToOn.setOn();
        }
    }
    
    @Override
    public void setOff(){
        for(Object s : this.sensors) {
            Sensor setToOff = (Sensor) s;
            if (setToOff.isOn()) {
                setToOff.setOff();
            }
        }        
    }
    
    @Override
    public int read(){
        if (this.sensors.isEmpty() || !this.isOn()) {
            throw new IllegalStateException("The average sensor is off.");
        } else {
            int numberOfSensors = this.sensors.size();
            int sumTemperature = 0;
            int averageReading;
            
            for (Object s : this.sensors) {
                Sensor toAdd = (Sensor) s;
                sumTemperature += toAdd.read();
            }
            
            averageReading = sumTemperature / numberOfSensors;
            this.readings.add(averageReading);
            
            return averageReading;
        }
    }

    public List<Integer> readings(){
        return readings;
    }
}