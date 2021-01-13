
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        HashMap<String, Integer> test = new HashMap<>();
        test.add("hatdog", 1);
        System.out.println(test.get("hatdog"));
        test.remove("hatdog");
        System.out.println(test.get("hatdog"));
    }

}
