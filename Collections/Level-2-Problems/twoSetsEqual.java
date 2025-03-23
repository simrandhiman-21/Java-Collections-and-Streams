import java.util.*;

public class twoSetsEqual {
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
            
            // // .equals check content and size 
            // if(set1.equals(set2)){
            //     System.out.println("Sets are Equal ");
            // }
            // else{
            //     System.out.println("Sets are Not Equal "); 
            // }

            boolean flag=false;
            if(set1.size()!=set2.size()){
                System.out.println("Comparing Size "+ "Sets are Not Equal ");
            } //removed duplicate at the time of input 
            
            
            for(int i:set1){
                 if(!set2.contains(i)){
                    flag=true;
                    break;
                }
            }

            //printing 
            if(flag){
                System.out.println("Sets are Not Equal "); 
            }
            else{
                System.out.println("Sets are Equal ");
            }


    }
}
