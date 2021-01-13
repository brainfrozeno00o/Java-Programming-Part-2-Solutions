package FlightControl;

import FlightControl.ui.TextUI;
import FlightControl.logic.FlightControl;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        FlightControl fc = new FlightControl();
        TextUI textUI = new TextUI(fc, scanner);
        textUI.start();
    }
}
