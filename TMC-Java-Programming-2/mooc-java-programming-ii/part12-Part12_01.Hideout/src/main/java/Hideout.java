/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john.lingad
 * @param <T>
 */
public class Hideout<T> {
    T val;
    
    public Hideout() {
        
    }
    
    public void putIntoHideout(T toHide) {
        this.val = toHide;
    }
    
    public T takeFromHideout() {
        if (this.val != null) {
            T toReturn = val;
            val = null;
            return toReturn;
        }
        return null;
    }
    
    public boolean isInHideout() {
        if (this.val != null) {
            return true;
        }
        return false;
    }
    
}
