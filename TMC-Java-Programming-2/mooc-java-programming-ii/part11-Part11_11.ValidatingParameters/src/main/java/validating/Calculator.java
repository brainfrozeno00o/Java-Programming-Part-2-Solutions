package validating;

public class Calculator {

    public int factorial(int num) {
        
        if (num < 0){
            throw new IllegalArgumentException("You can only give a non-negative number for factorial to work");
        }

        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        
        if (setSize < 0 || subsetSize < 0 || subsetSize > setSize) {
            throw new IllegalArgumentException("The set size and subset size should not be negative and/or the subset size cannot be greater than the set size.");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
