/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author john.lingad
 */
public class Herd implements Movable{
    private List<Movable> herd;
    
    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }
    
    @Override
    public void move(int dx, int dy){
        for (Movable m : this.herd) {
            m.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String herd = "";
        for (Movable m : this.herd) {
            herd = herd + m.toString() + "\n";
        }
        return herd;
    }
}
