import java.util.*;
public class SymmetricDifference {
    public static void main(String[] args) {
        //input 
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
        //call
        findSymmertricdiff(set1,set2);
    }
    static void findSymmertricdiff(HashSet<Integer> set1,HashSet<Integer> set2){
        HashSet<Integer> unionset=findUnion(set1,set2);
        HashSet<Integer> intersectionset=findIntersection(set1,set2);

        for(int i:intersectionset){
            if(unionset.contains(i)){
                unionset.remove(i);
            }
        }
        System.out.println(unionset);
    }  
    
    static HashSet<Integer> findUnion(HashSet<Integer> set1,HashSet<Integer> set2){
        HashSet<Integer> set3=new HashSet<>();
            set3.addAll(set1);
            set3.addAll(set2);
            return set3;
    }

    static HashSet<Integer> findIntersection(HashSet<Integer> set1,HashSet<Integer> set2){
        HashSet<Integer> set3=new HashSet<>();
            for(int i:set1){
                if(set2.contains(i)){
                    set3.add(i);
                }
            }
        return set3; 
    }  
}
