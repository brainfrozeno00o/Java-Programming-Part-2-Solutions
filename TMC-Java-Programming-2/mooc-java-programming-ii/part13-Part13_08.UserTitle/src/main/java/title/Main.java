package title;

import javafx.application.Application;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please put the title of the window: ");
        String title = sc.next();
        
        Application.launch(UserTitle.class,
                "--title=" + title);

    }

}
