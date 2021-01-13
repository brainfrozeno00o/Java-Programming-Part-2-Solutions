 
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] commands = input.split(" ");
            String command = commands[0];
            int value = Integer.valueOf(commands[1]);
            
            if (command.equalsIgnoreCase("add")) {
                if (value > 0) {
                    if (first + value > 100) {
                        first = 100;
                    } else {
                        first += value;
                    }
                }
            } else if (command.equalsIgnoreCase("move")) {
                if (value > 0 && first > 0) {
                    int previousFirst = 0;
                    if (value > first) {
                        previousFirst = first;
                        first = 0;
                    } else {
                        first -= value;
                    }
                    
                    if (second + value > 100) {
                        second = 100;
                    } else {
                        if (value > previousFirst && previousFirst > 0) {
                            second += previousFirst;
                        } else {
                            second += value;   
                        }
                    }
                }
            } else if (command.equalsIgnoreCase("remove")) {
                if (value > 0) {
                    if (second - value < 0) {
                        second = 0;
                    } else {
                        second -= value;
                    }
                }
            }
            
            System.out.println("");
        }
    }

}
