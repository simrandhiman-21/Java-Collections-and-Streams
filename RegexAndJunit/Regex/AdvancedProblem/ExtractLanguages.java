// package RegexAndJunit.Regex;

import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class ExtractLanguages {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with programming languages:");
        String input = sc.nextLine();
        sc.close();

        // Regex to match common programming languages
        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP|Rust|R|TypeScript)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> languages = new ArrayList<>();

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        if (!languages.isEmpty()) {
            System.out.println("Programming Languages Found: " + String.join(", ", languages));
        } else {
            System.out.println("No programming languages found.");
        }
    }
}
