import java.util.*;
public class removeDuplicate {
    public static void main(String[] args) {
        
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of elements in the list");
            int n=sc.nextInt();
            sc.nextLine();  // Consume the newline      

            ArrayList<Integer> arrayList = new ArrayList<>();
            System.out.println("Enter the elements of the list");
            for(int i=0;i<n;i++){
                arrayList.add(sc.nextInt());
            }

            LinkedHashSet<Integer> set=new LinkedHashSet<>();
            for(int i:arrayList){
                set.add(i);
            }

            System.out.println("Printing elemnts in preversed order removing duplicates ");
            for(int i:set){
                System.out.print(i+" ");
            }
        
    }
}
