
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random rand;

    public LotteryRow() {
        rand = new Random();
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        for (int i = 0; i < 7; ++i) {
            int generatedNumber;
            do {
               generatedNumber = rand.nextInt(40) + 1;
            } while(this.containsNumber(generatedNumber));
            this.numbers.add(generatedNumber);
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return this.numbers.contains(number);
    }
}

