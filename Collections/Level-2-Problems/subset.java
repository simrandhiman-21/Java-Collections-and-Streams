import java.util.*;

public class subset {
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

        System.out.println("Enter the number of elements in the Set 2");
        int n2=sc.nextInt();
        sc.nextLine();  // Consume the newline     

        HashSet<Integer> set2=new HashSet<>();
        System.out.println("Enter the elements of the Set 2 ");
        for(int i=0;i<n2;i++){
            set2.add(sc.nextInt());
        }

        subset(set1,set2);
    }

        static void subset( HashSet<Integer> set1, HashSet<Integer> set2){
            boolean flag=false;
            for(int i:set1){
                if(!set2.contains(i)){
                    flag=true;
                    break;
                }
            }
            if(flag) System.out.println("Not a Subset");
            else System.out.println(" Yes Subset");
        }    
}
