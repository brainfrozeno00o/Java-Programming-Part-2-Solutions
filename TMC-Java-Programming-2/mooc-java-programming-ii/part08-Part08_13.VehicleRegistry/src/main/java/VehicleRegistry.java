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
public class VehicleRegistry {
    private HashMap<LicensePlate, String> vehicles;
    
    public VehicleRegistry() {
        this.vehicles = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if(this.vehicles.get(licensePlate) == null) {
            this.vehicles.put(licensePlate, owner);
            return true;
        } else {
            return false;
        }
    }
    
    public String get(LicensePlate licensePlate) {
        return this.vehicles.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if(this.vehicles.get(licensePlate) != null) {
            this.vehicles.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }
    
    public void printLicensePlates() {
        for (LicensePlate lp : this.vehicles.keySet()) {
            System.out.println(lp);
        }
    }
    
    public void printOwners() {
        ArrayList<String> printed = new ArrayList();
        
        for (String owner : this.vehicles.values()) {
            if (!printed.contains(owner)) {
                System.out.println(owner);
                printed.add(owner);
            }
        }
    }
}
