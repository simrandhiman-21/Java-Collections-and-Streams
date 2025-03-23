import java.util.*;
public class generateNBinaryNumers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of elements in the list");
            int n=sc.nextInt();
            sc.nextLine();  // Consume the newline

            Queue<Integer> queue = new LinkedList<>();
            System.out.println("Enter the elements of the list");
            for(int i=1;i<=n;i++){
                queue.offer(i);
            }

            ArrayList<String> str=new ArrayList<>();
            while(!queue.isEmpty()){
                int num=queue.poll();
                String binary=Integer.toBinaryString(num);
                str.add(binary);
            }
            System.out.println(str);
    }
}
