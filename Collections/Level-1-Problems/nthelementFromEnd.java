import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class nthelementFromEnd {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of elements in the Linkedlist");
            int n=sc.nextInt();
            sc.nextLine();  // Consume the newline      

            LinkedList<Integer> linklist = new LinkedList<>();
            System.out.println("Enter the elements of the list");
            for(int i=0;i<n;i++){
                linklist.add(sc.nextInt());
            }

            System.out.println("Enter K position ");
            int k=sc.nextInt();

            System.out.println("Nth Element from End "+linklist.get(n-k));
    }
}
