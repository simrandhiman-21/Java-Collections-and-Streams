import java.util.*;

public class RotateElements {
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

            System.out.println("Enter position to Rotate ");
            int k=sc.nextInt();
            sc.nextLine();  // Consume the newline

             // Handle cases where k > n
            k = k % n; 

            int[] result=rotateByTwo(arrayList,k); //right 
            System.out.println("Rotated ArrayList ");
            for(int i:result){
                System.out.print(i+" ");
            }
        }

        static int[] rotateByTwo(ArrayList<Integer> list,int k){

            int n=list.size();
            int[] result=new int[n];
            int index=0;

            for(int i=k;i<n;i++){
                result[index++]=list.get(i);
            }
            for(int i=0;i<k;i++){
                result[index++]=list.get(i);
            }
            return result;
        }
}
