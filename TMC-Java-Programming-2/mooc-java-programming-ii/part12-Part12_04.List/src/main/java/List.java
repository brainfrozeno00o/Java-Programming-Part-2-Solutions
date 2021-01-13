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
public class List<T> {
    
    private T[] values;
    private int firstFreeIndex;
    
    public List() {
        values = (T[]) new Object[10];
        firstFreeIndex = 0;
    }
    
    public void add(T value){
        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }
    
    public boolean contains(T value){
        for (int i = 0; i < this.firstFreeIndex; ++i) {
            if (this.values[i].equals(value)){
                return true;
            }
        }
        return false;
    }
    
   public int indexOfValue(T value){
       for (int i = 0; i < this.firstFreeIndex; ++i) {
           if (this.values[i].equals(value)) {
               return i;
           }
       }
       
       return -1;
   }
   
   private void moveToTheLeft(int fromIndex) {
       for (int i = fromIndex; i < this.firstFreeIndex - 1; ++i) {
           this.values[i] = this.values[i + 1];
       }
   }
   
   private void remove(T value){
       int indexOfValue = indexOfValue(value);
       if (indexOfValue < 0) {
           return;
       }
       
       moveToTheLeft(indexOfValue);
       this.firstFreeIndex--;
   }
   
   public int size(){
       return this.firstFreeIndex;
   }
   
}
