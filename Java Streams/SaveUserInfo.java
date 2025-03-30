import java.io.*;

public class SaveUserInfo {

    public static void main(String[] args) {
        String fileName = "user_info.txt";  // File to save user info

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName)) {

            // Get user input
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Write data to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("User information saved to " + fileName);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
