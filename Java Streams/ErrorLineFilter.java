import java.io.*;

public class ErrorLineFilter {

    public static void main(String[] args) {
        String filePath = "largefile.txt";    // Path to the large text file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {   // Case-insensitive match
                    System.out.println("Line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
