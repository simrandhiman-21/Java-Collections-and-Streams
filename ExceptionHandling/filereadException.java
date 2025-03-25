package ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

    public class filereadException {
        public static void main(String[] args) {
            File file=new File("C:\\Users\\lovel\\Desktop\\bridgelabz-workspace\\Java Collections and Streams\\ExceptionHandling\\data.txt");

            try{ 
                
                Scanner sc=new Scanner(file);
                System.out.println("Printing file content :");
                while(sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                } 
                sc.close();         
            
            }
            catch(FileNotFoundException e){
                System.out.println("File Not Found ");
            }
        
            
        }
    }
