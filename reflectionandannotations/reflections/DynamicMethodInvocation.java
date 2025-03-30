package reflectionandannotations.reflections;


import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = sc.nextLine();

        System.out.print("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        // Create object dynamically
        MathOperations mathOps = new MathOperations();

        // Get method by name
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

        // Invoke the method dynamically
        int result = (int) method.invoke(mathOps, num1, num2);

        System.out.println("Result: " + result);

        sc.close();
    }
}
