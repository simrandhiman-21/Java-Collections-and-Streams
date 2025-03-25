package ExceptionHandling;

import java.util.Scanner;

public class throwvsthrows{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount ");
        double amount=sc.nextDouble();

        System.out.println("Enter Rate ");
        double rate=sc.nextDouble();

        System.out.println("Enter years ");
        int years=sc.nextInt();

        try {
            calculateInterest(amount,rate,years);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
    static void calculateInterest(double amount, double rate, int years){
        if(amount<=0 || rate<=0){
            throw new IllegalArgumentException("Amount or Rate is can't be Negative ");
        }
        else{
             double pricnple=(amount+rate+years)/100;
            System.out.println("Simple Interest is "+pricnple);
        }

    }
}
