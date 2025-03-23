import java.util.*;
public class unionIntersection {
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

            //calls
           findUnion(new HashSet<>(set1),new HashSet<>(set2));
           findIntersection(new HashSet<>(set1),new HashSet<>(set2));

           System.out.println("prinintg Original ");
           System.out.println(set1);
           System.out.println(set2);


        }
        static void findUnion(HashSet<Integer> set1,HashSet<Integer> set2){
                set1.addAll(set2);
                System.out.println("Union of 2 Sets "+set1);            
    
        }

        static void findIntersection(HashSet<Integer> set1,HashSet<Integer> set2){
            HashSet<Integer> set3=new HashSet<>();
            for(int i:set1){
                if(set2.contains(i)){
                    set3.add(i);
                }
            }
            System.out.println("Intersection of 2 Sets "+set3);   
        }
}
