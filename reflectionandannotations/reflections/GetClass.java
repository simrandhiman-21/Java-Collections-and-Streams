package reflectionandannotations.reflections;
import java.util.Scanner;
import java.lang.reflect.*;
public class GetClass {

        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter class name: ");
            String className = sc.nextLine();

            Class<?> cls = Class.forName(className);

            System.out.println("\nClass: " + cls.getName());

            System.out.println("\nFields:");
            for (Field f : cls.getDeclaredFields()) {
                System.out.println(f);
            }

            System.out.println("\nConstructors:");
            for (Constructor<?> c : cls.getDeclaredConstructors()) {
                System.out.println(c);
            }

            System.out.println("\nMethods:");
            for (Method m : cls.getDeclaredMethods()) {
                System.out.println(m);
            }
    }
}
