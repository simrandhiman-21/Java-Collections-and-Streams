import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InvertMap {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        

        HashMap<String,Integer> map=new HashMap<>();
        while(true){
            System.out.println("Enter name ");
            String name=sc.nextLine();

            if(name.equalsIgnoreCase("exist"))break;

            System.out.println("Enter id "+name );
            int id=sc.nextInt();            
            sc.nextLine();

            map.put(name,id);
        }

        // System.out.println(map);
        //Input: {A=1, B=2, C=1} → Output: {1=[A, C], 2=[B]}.

        HashMap<Integer,ArrayList<String>> invertMap=new HashMap<>();
        for(String str:map.keySet()){
            int val=map.get(str);
            
            invertMap.putIfAbsent(val,new ArrayList<>());
            invertMap.get(val).add(str);
        }

        System.out.println(invertMap);        
        
    }
}
