package ExceptionHandling;

import java.util.Scanner;

public class ExceptionPropagationinMethods {
    public static void main(String[] args) {

        ExceptionPropagationinMethods obj=new ExceptionPropagationinMethods();
        Scanner sc=new Scanner(System.in);
        int a=0;
        int b=0;
        try {
            System.out.println("Enter N1 ");
            a = sc.nextInt();
            System.out.println("Enter N2 ");
            b = sc.nextInt();
            int div=a/b;
            System.out.println(div);

            obj.method2();
            
        } catch (ArithmeticException e) {
            System.out.println("Main is handling Arithmetic Exception "+ e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static void method1(){
        System.out.println("\nThrowing exception from method1...");
        int result=10/0;
        System.out.println("This is not excuted ");
    }
    static void method2(){
        method1();
        System.out.println("I'm method 2 ");
    }  
}
