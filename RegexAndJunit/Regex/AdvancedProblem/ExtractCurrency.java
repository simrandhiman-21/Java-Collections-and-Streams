// package RegexAndJunit.Regex;

import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class ExtractCurrency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with prices or currency values:");
        String input = sc.nextLine();
        sc.close();

        // Regex pattern to match currency values (e.g., $45.99) and decimal numbers (e.g., 10.50)
        String regex = "\\$?\\d+\\.\\d{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> prices = new ArrayList<>();

        while (matcher.find()) {
            prices.add(matcher.group());
        }

        if (!prices.isEmpty()) {
            System.out.println("Extracted Values: " + String.join(", ", prices));
        } else {
            System.out.println("No currency or decimal values found.");
        }
    }
}
