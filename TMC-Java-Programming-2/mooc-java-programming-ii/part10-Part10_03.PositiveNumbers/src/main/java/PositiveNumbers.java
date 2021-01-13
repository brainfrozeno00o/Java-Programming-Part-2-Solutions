
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        // test your method here
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true){
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
           
            numbers.add(Integer.valueOf(input));
        }

        List<Integer> positives = positive(numbers);
        
        for (int positive : positives){
            System.out.println(positive);
        }
        
    }
    
    public static List<Integer> positive(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toList());
    }

}
