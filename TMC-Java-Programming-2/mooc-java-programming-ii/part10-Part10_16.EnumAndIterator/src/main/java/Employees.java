/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author john.lingad
 */
public class Employees {
    private List<Person> employees;
    
    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd){
        Iterator<Person> personsToAdd = peopleToAdd.iterator();
        
        while (personsToAdd.hasNext()) {
            this.employees.add(personsToAdd.next());
        }
    }
    
    public void print() {
        Iterator<Person> people = this.employees.iterator();
        
        while (people.hasNext()) {
            System.out.println(people.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> people = this.employees.iterator();
        
        while (people.hasNext()) {
            Person person = people.next();
            if (person.getEducation().equals(education)){
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> people = this.employees.iterator();
        
        while (people.hasNext()) {
            if (people.next().getEducation().equals(education)){
                people.remove();
            }
        }
    }
}
