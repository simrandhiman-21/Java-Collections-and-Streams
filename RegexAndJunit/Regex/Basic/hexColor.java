package RegexAndJunit.Regex.Basic;

import java.util.Scanner;

public class hexColor {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter Hex color Code ");
        String input=sc.nextLine();

        String regex="^[#]{1}[0-9A-Fa-f]{6}";

        if(input.matches(regex)){
            System.out.println("Valid Hex color Code ");
        }
        else{
            System.out.println("Invalid");
        }
    }
}
