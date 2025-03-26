package RegexAndJunit.Regex.Basic;

import java.util.Scanner;
import java.util.regex.Pattern;

public class validateUername {
    public static void main(String[] args) {
        

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter UserName");
        String input=sc.nextLine();

        String regex="^[a-zA-Z][a-zA-Z0-9_]{5,15}$";

        if(Pattern.matches(regex,input)){
            System.out.println("Valid UserName");
        }
        else{
            System.out.println("Not a Valid UserName");
        }

    }    
}
