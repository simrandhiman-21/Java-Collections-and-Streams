import java.util.*;
public class sortedSet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the Set 1");
        int n=sc.nextInt();
        sc.nextLine();  // Consume the newline      


        HashSet<Integer> set1=new HashSet<>();
        System.out.println("Enter the elements of the Set 2 ");
        for(int i=0;i<n;i++){
            set1.add(sc.nextInt());
        }

        TreeSet<Integer> treeset=new TreeSet<>(set1);

        //printing
        System.out.println(treeset);

    }
    
}
