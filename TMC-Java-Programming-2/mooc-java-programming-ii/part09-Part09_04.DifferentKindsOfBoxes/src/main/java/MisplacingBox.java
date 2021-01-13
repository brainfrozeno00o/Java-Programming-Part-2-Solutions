/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john.lingad
 */
public class MisplacingBox extends Box {
    private Item currentItem;
    
    public MisplacingBox() {
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
        return false;
    }
    
}
