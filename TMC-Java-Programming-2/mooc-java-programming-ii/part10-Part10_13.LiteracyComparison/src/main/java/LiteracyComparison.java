
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .sorted((q1, q2) -> {return Double.valueOf(q1[5]).compareTo(Double.valueOf(q2[5]));})
                    .forEach(query -> {
                        if (query[2].trim().length() == 8) {
                            query[2] = query[2].trim().substring(0, 4);
                        } else {
                            query[2] = query[2].trim().substring(0, 6);
                        }
                        System.out.println(query[3] + " (" + query[4] + "), " + query[2] + ", " + query[5]);
                     });
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
