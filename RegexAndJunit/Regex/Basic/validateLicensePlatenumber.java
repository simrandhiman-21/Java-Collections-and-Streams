package RegexAndJunit.Regex.Basic;

import java.util.Scanner;

public class validateLicensePlatenumber {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter License Plate number ");
        String input=sc.nextLine();

        String regex="^[A-Z]{2}[0-9]{4}";

        if(input.matches(regex)){
            System.out.println("Valid License Plate Number ");
        }
        else{
            System.out.println("Invalid");
        }
    }
}
