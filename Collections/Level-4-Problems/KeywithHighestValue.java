import java.util.*;
public class KeywithHighestValue {
    public static void main(String[] args) {
    
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n ");
        int n=sc.nextInt();

        TreeMap<String,Integer> map=new TreeMap<>();

        for(int i=0;i<n;i++){
            
            System.out.println("Enter name ");
            sc.nextLine();
            String name=sc.nextLine();
            System.out.println("Enter id "+name);
            int id=sc.nextInt();
            map.put(name,id);
        }
        
        //System.out.println(map);

        
        int max=Integer.MIN_VALUE;
        String maxchar="";
        for(String str:map.keySet()){
            int val=map.get(str);
                if(val>max){
                    max=val;
                    maxchar=str;
                }
        }    
        
        System.out.println("Key with highest value is "+maxchar);       
        
    }
}
