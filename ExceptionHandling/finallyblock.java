package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class finallyblock {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=0;
        int n2=0;
        try {
            System.out.println("Enter First number ");
            n1=sc.nextInt();
            System.out.println("Enter Second number ");
            n2=sc.nextInt();
            int div=n1/n2;
            System.out.println("DIVISION : "+div);
            
        }catch(ArithmeticException e){
            System.out.println("Enter valid number, denominator should not be zero ");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Operation completed");
        }
    }
}
