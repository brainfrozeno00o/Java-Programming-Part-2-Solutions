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
public class ShoppingCart {
    private List items;
    
    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }
    
    public void add(String product, int price) {
        boolean addItem = true;
        for (Object item : items) {
            Item realItem = (Item) item;
            if (item.toString().contains(product)) {
                realItem.increaseQuantity();
                addItem = false;
                break;
            }
        }
        if (addItem) {
           this.items.add(new Item(product, 1, price));   
        }
    }
    
    public int price() {
        int totalPrice = 0;
        for (Object item : this.items) {
            Item realItem = (Item) item;
            totalPrice += (realItem.price());
        }
        return totalPrice;
    }
    
    public void print() {
        for (Object item : this.items) {
            Item realItem = (Item) item;
            System.out.println(realItem);
        }
    }
    
}
