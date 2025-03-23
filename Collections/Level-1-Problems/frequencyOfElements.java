import java.util.*;
public class frequencyOfElements {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of elements in the list");
            int n=sc.nextInt();
            sc.nextLine();  // Consume the newline

            ArrayList<String> arrayList = new ArrayList<>();
            System.out.println("Enter the elements of the list");
            for(int i=0;i<n;i++){
                arrayList.add(sc.nextLine());
            }
            
            Map<String, Integer> map = new HashMap<>();
            frequency(arrayList,n,map);

            System.out.println("Frequency Map");
            // for(String str:map.keySet()){
            //     System.out.println(str+" "+map.get(str));
            // }
            System.out.println(map);
    }


        static void frequency(ArrayList<String> list,int n, Map<String, Integer> map){
            for(String word:list){
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
}
