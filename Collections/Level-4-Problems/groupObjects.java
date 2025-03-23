import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class groupObjects{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in); 
        HashMap<String,String> map=new HashMap<>();     
        while(true){
            System.out.println("Enter name of Employe ");
            String name=sc.nextLine();
            
            if(name.equalsIgnoreCase("exist"))break;
            
            System.out.println("Enter Employe department "+name );
            String dep=sc.nextLine();            

            map.put(name,dep);
        }
        //department,[names of employe ]
        HashMap<String,ArrayList<String>> answermap=new HashMap<>();

        for(String key:map.keySet()){
            String dep=map.get(key);

            answermap.putIfAbsent(dep,new ArrayList<>());
            answermap.get(dep).add(key);
        }
        System.out.println(answermap);

        
    }
}