/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author john.lingad
 */
public class TodoList {
    private ArrayList<String> tasks;
    
    public TodoList() {
        this.tasks = new ArrayList();
    }
    
    public void add(String task) {
        this.tasks.add(task);
    }
    
    public void print() {
        for(int i = 0; i < tasks.size(); i++) {
            System.out.println((i+1) + ": " + tasks.get(i));
        }
    }
    
    public void remove(int number) {
        this.tasks.remove(number-1);
    }
}
