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
public class BoxWithMaxWeight extends Box {
    private int maxWeight;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity) {
        this.maxWeight = capacity;
        this.items = new ArrayList();
    }
    
    @Override
    public void add(Item item) {
        int currentWeight = 0;
        for (Item i : this.items){
            currentWeight += i.getWeight();
        }
        
        if(item.getWeight() + currentWeight <= this.maxWeight) {
            this.items.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        if (items.contains(item)) {
            return true;
        }
        return false;
    }
}
