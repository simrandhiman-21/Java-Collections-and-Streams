import java.util.*;
class Pair{
    String name;
    int no;
        Pair(String name,int no){
            this.name=name;
            this.no=no;
        }
        public String toString(){
            return "("+name+","+no+")";
        }
}
public class hospitalTirageSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of entries: ");
        int n = sc.nextInt();
                // PriorityQueue<Pair> queue=new PriorityQueue<>(Comparator.comparingInt(p->p.no));
           PriorityQueue<Pair> queue=new PriorityQueue<>((p1,p2)->Integer.compare(p2.no, p1.no));
                // PriorityQueue<Pair> queue=new PriorityQueue<>(Comparator.comparing(p->p.name)); //name (Lexicographical Order)
                // PriorityQueue<Pair> queue=new PriorityQueue<>(Comparator.comparing((Pair p)->p.name).reversed()); //name (Lexicographical Order)
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter id of patient ");
            int Priority = sc.nextInt();
            System.out.println("Enter name of patient ");
            sc.nextLine();
            String name = sc.nextLine();
            queue.offer(new Pair(name,Priority));
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll().name);
        }
    }
}