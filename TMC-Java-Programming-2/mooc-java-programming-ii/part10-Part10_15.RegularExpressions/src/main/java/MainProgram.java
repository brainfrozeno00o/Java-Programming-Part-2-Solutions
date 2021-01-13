

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Checker regexChecker = new Checker();
        
        System.out.println(regexChecker.allVowels("oioaa"));
        System.out.println(regexChecker.timeOfDay("23:59:59"));
    }
}
