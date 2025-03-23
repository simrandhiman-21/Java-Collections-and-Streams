//3ways //stacks//deque//collections
import java.util.*;

public class reverseQueue {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of elements in the list");
            int n=sc.nextInt();
            sc.nextLine();  // Consume the newline

            Queue<Integer> queue = new PriorityQueue<>();
            System.out.println("Enter the elements of the list");
            for(int i=0;i<n;i++){
                queue.offer(sc.nextInt());
            }

            Stack<Integer> st=new Stack<>();
            while(!queue.isEmpty()){
                st.push(queue.poll());
            }
            
            System.out.println("Reversed queue is:");
            while(!st.isEmpty()){
                System.out.print(st.peek()+" ");
                st.pop();
            }
    }
}
