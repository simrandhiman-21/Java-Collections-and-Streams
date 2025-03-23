import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

class WordFrequencyCounter{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        input=input.toLowerCase();

        LinkedHashMap<String,Integer> map=new LinkedHashMap<>(); //{hello=2, world=1, jav=1}
        //TreeMap<String,Integer> map=new TreeMap<>();  //{hello=2, jav=1, world=1}
        int index=0;
        for(String word:input.split(" ")){
            StringBuilder sb=new StringBuilder();
            for(char c:word.toCharArray()){
                if(Character.isLetter(c)){
                    sb.append(c);
                }
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }

        System.out.println(map);        
    }
}