
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> negatives = new ArrayList();
        ArrayList<String> positives = new ArrayList();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            
            if (Integer.valueOf(input) >= 0) {
                positives.add(input);
            } else {
                negatives.add(input);
            }
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        
        double average = 0.0;
        
        if (choice.equalsIgnoreCase("p")) {
            average = positives.stream().
                    mapToInt(number -> Integer.valueOf(number))
                    .average()
                    .getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        } else {
            average = negatives.stream().
                   mapToInt(number -> Integer.valueOf(number))
                   .average()
                   .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        }
     
    }
}
