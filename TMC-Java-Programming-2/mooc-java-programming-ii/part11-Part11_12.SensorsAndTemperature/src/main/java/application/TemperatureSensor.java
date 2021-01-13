/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author john.lingad
 */
public class TemperatureSensor implements Sensor {
    private boolean sensorState;
    private Random rand = new Random();
    
    public TemperatureSensor(){
        this.sensorState = false;
    }
    
    @Override
    public boolean isOn(){
        return sensorState;
    }
    
    @Override
    public void setOn(){
        this.sensorState = true;
    }
    
    @Override
    public void setOff(){
        this.sensorState = false;
    }
    
    @Override
    public int read(){
        if (sensorState) {
            return rand.nextInt(61) - 30; //(0-30) to (60-30) inclusive
        } else {
            throw new IllegalStateException("The sensor is not on.");
        }        
    }    
}
