// package RegexAndJunit.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAddress {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an IPv4 address:");
        String input = sc.nextLine().trim();
        sc.close();

        // IPv4 regex pattern: 0-255.0-255.0-255.0-255
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" + 
                       "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        if (Pattern.matches(regex, input)) {
            System.out.println("Valid IPv4 address");
        } else {
            System.out.println("Invalid IPv4 address");
        }
    }
}
