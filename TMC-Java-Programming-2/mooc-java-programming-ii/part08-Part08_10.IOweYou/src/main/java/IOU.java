/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
/**
 *
 * @author john.lingad
 */
public class IOU {
    private HashMap<String, Double> debts;
    
    public IOU() {
        this.debts = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        this.debts.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        if (this.debts.get(toWhom) != null) {
            return this.debts.get(toWhom);
        }
        return 0.0;
    }
}
