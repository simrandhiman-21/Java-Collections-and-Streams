package ExceptionHandling;

import java.util.Scanner;

public class nestedTryCatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Value of n");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter  Elements ");

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter Value of Index");
        int key=sc.nextInt();

        System.out.println("Enter Divisor ");
        int divisor=sc.nextInt();        
    

        try {
            System.out.println("Value at index X: "+arr[key]);
            try {
                int result=arr[key]/divisor;
                System.out.println("Division Result: " + result);                
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero: " + e.getMessage());
            }
        } catch (ArrayIndexOutOfBoundsException  e) {
            System.out.println("Invalid Index"+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Array is Empty  "+e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
