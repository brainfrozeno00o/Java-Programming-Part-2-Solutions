
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here
        int[] numbers = {8, -2, 3, 1, 1};

        System.out.println(sum(numbers, 0, numbers.length, 0, 999));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));
    }
    
    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        // do checks first
        if (fromWhere < 0) {
            fromWhere = 0;
        }
        
        if (toWhere > array.length) {
            toWhere = array.length;
        }
        
        if (smallest < fromWhere) {
            smallest = fromWhere;
        }
        
        if (largest > toWhere) {
            largest = toWhere;
        }
        
        int sum = 0;
        int negative = 0;
        
        for (int i = smallest; i < largest; ++i){
            if (array[i] < 0) negative += array[i];
            sum += Math.abs(array[i]);
        }
        
        return sum + negative;
    }

}
