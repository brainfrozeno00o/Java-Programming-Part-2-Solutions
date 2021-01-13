/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author john.lingad
 */
public class UserInterface {
    private Scanner scanner;
    private TodoList list;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();
            
            if (command.equalsIgnoreCase("stop")) {
                break;
            }
            
            if (command.equalsIgnoreCase("add")) {
                System.out.print("To add: ");
                String task = scanner.nextLine();
                list.add(task);
            } else if (command.equalsIgnoreCase("list")) {
                list.print();
            } else if (command.equalsIgnoreCase("remove")) {
                System.out.print("Which one is removed? ");
                int index = Integer.valueOf(scanner.nextLine());
                list.remove(index);
            }
        }
    }
}
