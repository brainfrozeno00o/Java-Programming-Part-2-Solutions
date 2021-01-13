
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList();
        
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookName = scanner.nextLine();
            
            if (bookName.isEmpty()) {
                break;
            }
            
            System.out.print("Input the age recommendation: ");
            String ageString = scanner.nextLine();
            int recommendedAge = Integer.valueOf(ageString);
            
            books.add(new Book(bookName, recommendedAge));
            System.out.println();
        }
        
        System.out.println("\n" + books.size() + " books in total.\n\nBooks:");
        
        Comparator<Book> bookComparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getName);
        
        Collections.sort(books, bookComparator);
        
        for (Book book : books){
            System.out.println(book);
        }

    }

}
