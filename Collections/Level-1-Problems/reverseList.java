import java.util.*;

public class reverseList {
    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the number of elements in the list");
    int n=sc.nextInt();

    ArrayList<Integer> arrayList = new ArrayList<>();
    System.out.println("Enter the elements of the list");
    for(int i=0;i<n;i++){
        arrayList.add(sc.nextInt());
    }

    reverselist(arrayList,n);

    System.out.println("Reverse ArrayList: ");
    System.out.print(arrayList+" ");



    // User input for LinkedList
    System.out.print("\nEnter the number of elements for LinkedList: ");
    int m = sc.nextInt();
    
    LinkedList<Integer> linkedList = new LinkedList<>();
    System.out.println("Enter " + m + " elements for LinkedList:");
    for (int i = 0; i < m; i++) {
        linkedList.add(sc.nextInt());
    }

    reverselinkedlist(linkedList, n);
    System.out.println("Reverse LinkedList: ");
    System.out.print(linkedList+" ");
}

    static <T> void reverselist(ArrayList<T> list,int n){
        for(int i=0;i<n/2;i++){
            T temp=list.get(i);
            list.set(i,list.get(n-i-1));
            list.set(n-i-1,temp);
        }
    }

    static <T> void reverselinkedlist(LinkedList<T> linkedList,int n){
        for(int i=0;i<n/2;i++){
            T temp=linkedList.get(i);
            linkedList.set(i,linkedList.get(n-i-1));
            linkedList.set(n-i-1,temp);
        }
    }
}
