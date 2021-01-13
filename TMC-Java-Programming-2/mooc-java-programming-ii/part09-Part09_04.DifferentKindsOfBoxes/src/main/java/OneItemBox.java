/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john.lingad
 */
public class OneItemBox extends Box {
    private Item currentItem;
    
    public OneItemBox() {
        this.currentItem = null;
    }
    
    @Override
    public void add (Item item) {
        if (this.currentItem == null) {
            this.currentItem = item;
        }
    }
    
    @Override
    public boolean isInBox(Item item){
        if (this.currentItem != null) {
            return this.currentItem.equals(item);
        }
        return false;
    }
    
}
