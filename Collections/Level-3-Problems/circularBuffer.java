import java.util.*;

public class circularBuffer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of elements in the list");
                int n=sc.nextInt();
                sc.nextLine();  // Consume the newline

                Queue<Integer> queue = new ArrayDeque<>(5);
                System.out.println("Enter the elements of the list");
                for(int i=0;i<n;i++){
                    queue.offer(sc.nextInt());
                }
            System.out.println("You have Entered Given Required Values ");
            System.out.println("Now starting Entering Next values ");
                while(true){
                    int next=sc.nextInt();
                    if(next==-1){
                        break;
                    }
                    queue.poll();
                    queue.add(next);             
                }


            System.out.println("Printing Values ");
            while(!queue.isEmpty()){
                System.out.println(queue.poll());
            }
    }
    
}
