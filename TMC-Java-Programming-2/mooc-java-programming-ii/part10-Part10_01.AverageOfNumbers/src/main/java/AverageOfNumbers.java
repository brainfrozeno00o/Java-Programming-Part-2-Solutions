
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> numbers = new ArrayList();
        // Write your program here
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true){
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
           
            numbers.add(input);
        }
        
        double average = numbers.stream()
                .mapToInt(number -> Integer.valueOf(number))
                .average()
                .getAsDouble();
        
        System.out.println("average of the numbers: " + average);
    }
}
