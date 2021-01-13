/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author john.lingad
 */
public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
    
    public double maxValue() {
        if (!this.history.isEmpty()) {
            return Collections.max(this.history);
        }
        return 0;
    }
    
    public double minValue() {
        if (!this.history.isEmpty()) {
            return Collections.min(this.history);
        }
        return 0;
    }

    public double average() {
        if (!this.history.isEmpty()) {
            double sum = 0;
            for (double d : this.history) {
                sum += d;
            }
            return sum / this.history.size();
        }
        return 0;
    }
}
