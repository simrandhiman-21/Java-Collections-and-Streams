package ExceptionHandling;
import java.util.*;

class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message){
        super(message);
    }
}
// //custom catch (InvalidAgeException | InvalidAmountException e)
public class customException {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int age=sc.nextInt();
        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        sc.close();        
    }
    static void validateAge(int age){
        if(age<18){
            throw new InvalidAgeException("Invalid Age: Access denied! Age must be 18 or above");
        }else{
            System.out.println("Age is valid");
        }
    }
}
