// package RegexAndJunit.Regex;

import java.util.Scanner;
import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with SSN:");
        String input = sc.nextLine().trim();
        sc.close();

        // Regex pattern for SSN: XXX-XX-XXXX
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean validSSN = false;

        while (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
            validSSN = true;
        }

        // Check for invalid format without dashes
        if (!validSSN) {
            if (input.matches(".*\\b\\d{9}\\b.*")) {
                System.out.println("❌ \"" + input.replaceAll("\\D", "") + "\" is invalid");
            } else {
                System.out.println("❌ No valid SSN found.");
            }
        }
    }
}
