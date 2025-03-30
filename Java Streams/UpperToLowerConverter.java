import java.io.*;

public class UpperToLowerConverter {

    public static void main(String[] args) {
        String sourceFile = "source.txt";     // Source text file
        String destFile = "lowercase.txt";    // Destination file with lowercase content

        try (
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))
        ) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());  // Convert to lowercase
                writer.newLine();                  // Add new line
            }

            System.out.println("File converted successfully: " + destFile);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
