/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author john.lingad
 */
public class StorageFacility {
    private HashMap<String, ArrayList<String>> storages;
    
    public StorageFacility() {
        this.storages = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        if (!this.storages.containsKey(unit)) {
            ArrayList<String> items = new ArrayList();
            items.add(item);
            this.storages.put(unit, items);
        } else { 
            this.storages.get(unit).add(item);
        }
    }
    
    public ArrayList<String> contents(String storageUnit) {
        if (this.storages.containsKey(storageUnit)) {
            return this.storages.get(storageUnit);
        }
        return new ArrayList<>();
    }
    
    public void remove(String storageUnit, String item) {
        if (this.storages.containsKey(storageUnit)) {
            if (this.storages.get(storageUnit).contains(item)) {
                this.storages.get(storageUnit).remove(item);
            }
            
            if (this.storages.get(storageUnit).isEmpty()) {
                this.storages.remove(storageUnit);
            }
        }
        
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();
        for (String unit : this.storages.keySet()) {
            if (!this.storages.get(unit).isEmpty()) {
                units.add(unit);
            }
        }
        return units;
    }
}
