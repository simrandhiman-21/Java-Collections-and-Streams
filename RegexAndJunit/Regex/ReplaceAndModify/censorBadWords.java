package RegexAndJunit.Regex.ReplaceAndModify;

import java.util.regex.*;
import java.util.*;

public class censorBadWords {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
        System.out.println("Enter String with Censor words ");
        String input=sc.nextLine();

        String[] badwords={"damn", "stupid", "idiot", "hell", "crap"};
        for(String bad:badwords){
            input=input.replaceAll("\\b" +Pattern.quote(bad) + "\\b", "****");
        }
        System.out.println(input);

        // Escapes special characters in bad words to avoid regex issues.
    }
    
}
