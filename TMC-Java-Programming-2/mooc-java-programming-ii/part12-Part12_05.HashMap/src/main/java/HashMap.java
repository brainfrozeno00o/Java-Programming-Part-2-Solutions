/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author john.lingad
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {
    
    private ArrayList<Pair<K,V>> values;
    // private int firstFreeIndex;
    
    public HashMap() {
        this.values = new ArrayList<>();
        // this.firstFreeIndex;
    }
    
    public V get(K key){
        for (int i = 0; i < this.values.size(); ++i){
            Pair<K, V> currentPair = this.values.get(i);
            if (currentPair.getKey().equals(key)) {
                return currentPair.getValue();
            }
        }
        
        return null;
    }
    
    public void add(K key, V value) {
        int index = -1;
        
        for (int i = 0; i < this.values.size(); ++i){
            Pair<K, V> currentPair = this.values.get(i);
            if (currentPair.getKey().equals(key)) {
                currentPair.setValue(value);
                this.values.set(i, currentPair);
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            Pair<K, V> newPair = new Pair<>(key, value);
            this.values.add(newPair);
        }
    }
    
    public void remove(K key){
        for(int i = 0; i < this.values.size(); ++i){    
            Pair<K, V> currentPair = this.values.get(i);
            if (currentPair.getKey().equals(key)){
                this.values.remove(currentPair);
                break;
            }
        }
    }
    
}
