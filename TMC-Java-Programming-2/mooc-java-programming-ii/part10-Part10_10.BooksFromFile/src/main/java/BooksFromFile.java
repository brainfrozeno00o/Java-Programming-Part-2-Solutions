
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    
    public static List<Book> readBooks(String file){
        try {
            return Files.lines(Paths.get(file))
                   .map(string -> string.split(","))
                   .map(details -> new Book(details[0], Integer.valueOf(details[1]), Integer.valueOf(details[2]), details[3]))
                   .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

}
