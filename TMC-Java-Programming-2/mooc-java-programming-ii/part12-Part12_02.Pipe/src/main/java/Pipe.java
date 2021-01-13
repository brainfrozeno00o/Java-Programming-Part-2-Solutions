/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author john.lingad
 * @param <T>
 */
public class Pipe<T> {
    ArrayList<T> lis = new ArrayList<>();;
    
    public Pipe(){
         
    }
    
    public void putIntoPipe(T value) {
        lis.add(value);
    }
    
    public T takeFromPipe() {
        if (!lis.isEmpty()) {
            T toReturn = lis.get(0);
            this.lis.remove(0);
            return toReturn;
        }
        return null;
    }
    
    public boolean isInPipe() {
        return !lis.isEmpty();
    }
    
}
