// package RegexAndJunit.Regex;

import java.util.Scanner;
import java.util.regex.*;
import java.util.HashSet;

public class FindRepeatingWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine().toLowerCase().trim();
        sc.close();

        // Regex to match repeating words
        String regex = "\\b(\\w+)\\b(?:\\s+\\1\\b)+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        HashSet<String> repeatedWords = new HashSet<>();

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }

        if (!repeatedWords.isEmpty()) {
            System.out.println("Repeating Words: " + String.join(", ", repeatedWords));
        } else {
            System.out.println("No repeating words found.");
        }
    }
}
