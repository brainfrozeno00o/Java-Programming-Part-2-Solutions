/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author john.lingad
 */
public class Box implements Packable{
    private double capacity;
    private ArrayList<Packable> packs;
    
    public Box(double capacity) {
        this.capacity = capacity;
        this.packs = new ArrayList();
    }
    
    public void add(Packable pack) {
        if (pack.weight() + this.weight() <= this.capacity) {
            packs.add(pack);
        }
    }
    
    @Override
    public double weight() {
        double weight = 0;
        for (Packable p : packs) {
            weight += p.weight();
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + packs.size() + " items, total weight " + this.weight() + " kg";
    }
}
