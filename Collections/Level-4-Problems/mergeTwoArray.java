import java.util.HashMap;
import java.util.Scanner;

public class mergeTwoArray {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        // char[] arr={'a','c','x','a','x','w','x'};

        HashMap<Character,Integer> answermap=new HashMap<>();
        
        System.out.println("Enter n elements ");
        int n=sc.nextInt();
        char[] arr=new char[n];
        System.out.println("Enter n elements line by line ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.next().charAt(0);
        }

        System.out.println("Enter n2 elements ");
        int n2=sc.nextInt();
        char[] arr2=new char[n];
        System.out.println("Enter n elements line by line ");
        for(int i=0;i<arr2.length;i++){
            arr2[i]=sc.next().charAt(0);
        }

        for(char c:arr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:arr2){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        for(char c:map.keySet()){
            if(map2.containsKey(c)){
                int v1=map.get(c);
                int v2=map2.get(c);
                int sum=v1+v2;
                answermap.put(c,sum);
            }
        }

        for(char c:answermap.keySet()){
            System.out.println(c+" "+answermap.get(c));
        }
            
    }
}
