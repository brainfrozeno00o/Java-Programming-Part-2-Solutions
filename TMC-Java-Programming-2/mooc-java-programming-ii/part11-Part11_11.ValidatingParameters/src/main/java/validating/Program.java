/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validating;

/**
 *
 * @author john.lingad
 */
public class Program {
    public static void main(String[] args) {
        try {
            Statistics st = new Statistics();
            System.out.println("Printing the average of the statistics: " + st.average());
            System.out.println("Adding number 22");
            st.add(22);
            System.out.println("Printing the average of the statistics: " + st.average());           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }   
}
