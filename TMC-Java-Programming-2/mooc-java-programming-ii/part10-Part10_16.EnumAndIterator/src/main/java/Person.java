/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author john.lingad
 */
public class Person {
    private String name;
    private Education edu;
    
    public Person(String name, Education edu){
        this.name = name;
        this.edu = edu;
    }
    
    public Education getEducation() {
        return this.edu;
    }
    
    @Override
    public String toString() {
        return this.name + ", " + this.edu;
    }
}
