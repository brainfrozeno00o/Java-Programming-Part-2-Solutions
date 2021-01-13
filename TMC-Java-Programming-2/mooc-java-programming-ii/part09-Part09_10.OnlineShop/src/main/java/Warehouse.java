/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
/**
 *
 * @author john.lingad
 */
public class Warehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stocks;
    
    public Warehouse() {
        this.products = new HashMap<>();
        this.stocks = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stocks.put(product, stock);
    }
    
    public int price(String product) {
        if (products.containsKey(product)) {
            return products.get(product);
        }
        return -99;
    }
    
    public int stock(String product) {
        if (stocks.containsKey(product)) {
            return stocks.get(product);
        }
        return 0;
    }
    
    public boolean take(String product) {
        if (stocks.containsKey(product)) {
            if (stocks.get(product) - 1 >= 0) {
                int takeStock = stocks.get(product) - 1;
                stocks.put(product, takeStock);
                return true;
            }
        }
        return false;
    }
    
    public Set<String> products() {
        return products.keySet();
    }
}
