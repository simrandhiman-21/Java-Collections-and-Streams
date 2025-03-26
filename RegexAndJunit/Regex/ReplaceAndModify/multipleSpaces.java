package RegexAndJunit.Regex.ReplaceAndModify;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class multipleSpaces {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String with multiple spaces ");
        String input=sc.nextLine();

        
        System.out.println(input.trim().replaceAll("\\s+", " "));

    }
}
