package ExceptionHandling;

import java.util.Scanner;

public class multipleCatchBlocks {
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
        
        // int[] arr=null; //explicilty set 

        try {
            // System.out.println("Value at index X: "+arr[0]);
            System.out.println("Value at index X: "+arr[key]);
        } catch (ArrayIndexOutOfBoundsException  e) {
            System.out.println("Invalid Index");
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println("Array is Empty  ");
            System.out.println(e.getMessage());
        }
        finally {
            sc.close();
        }
        // //custom catch (InvalidAgeException | InvalidAmountException e)

    }
}
