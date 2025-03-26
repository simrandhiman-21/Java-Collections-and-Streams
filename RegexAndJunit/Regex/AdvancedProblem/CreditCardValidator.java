// package RegexAndJunit.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCardValidator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Credit Card Number:");
        String cardNumber = sc.nextLine().trim().replaceAll("\\s+", "");  // Remove spaces
        sc.close();

        // Visa: Starts with 4, 16 digits
        String visaRegex = "^4[0-9]{15}$";
        
        // MasterCard: Starts with 5, 16 digits
        String masterCardRegex = "^5[0-9]{15}$";

        if (Pattern.matches(visaRegex, cardNumber)) {
            System.out.println(" Valid Visa Card");
        } else if (Pattern.matches(masterCardRegex, cardNumber)) {
            System.out.println(" Valid MasterCard");
        } else {
            System.out.println("Invalid Credit Card Number");
        }
    }
}
