import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class mystack{
    Queue<Integer> q1=new LinkedList<Integer>();
    Queue<Integer> q2=new LinkedList<Integer>();

    public  void push(int i){
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(i);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    public  int pop(){
        if(!q1.isEmpty()){
            return q1.poll();
        }
        return -1;
    }
    public  int peek(){
        if(!q1.isEmpty()){
            return q1.peek();
        }
        return -1;
    }
    
    public void print(){
        System.out.println(q1);
    }

}
public class stackusingQueue {
    public static void main(String[] args) {

        mystack obj=new mystack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);

        System.out.println("Before Removing Elements");
        obj.print();

        int poped=obj.pop();
        System.out.println("Removed Element is "+poped);

        int top=obj.peek();
        System.out.println("Top Element is "+top);
        
        obj.print();        
    }
}
