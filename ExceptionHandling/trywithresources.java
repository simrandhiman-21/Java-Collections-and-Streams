package ExceptionHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class trywithresources {
    public static void main(String[] args) {
        String file="info.txt";
        try(BufferedReader reader =new BufferedReader(new FileReader(file))) {
                String firstLine=reader.readLine();

                if(firstLine!=null){
                    System.out.println("First line of file is "+firstLine);
                }
                else{
                    System.out.println("File is Empty ");
                }    
        } catch (IOException e) {
            System.out.println("Error File Reading ");
            
        }
        

    }
}
