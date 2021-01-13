
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] commands = input.split(" ");
            String command = commands[0];
            int value = Integer.valueOf(commands[1]);
            
            if (command.equalsIgnoreCase("add")) {
                first.add(value);
            } else if (command.equalsIgnoreCase("move")) {
                if (value > first.contains()) {
                    second.add(first.contains());
                } else {
                    second.add(value);
                }
                first.remove(value);
            } else if (command.equalsIgnoreCase("remove")) {
                second.remove(value);
            }
            
            System.out.println("");
        }
    }

}
