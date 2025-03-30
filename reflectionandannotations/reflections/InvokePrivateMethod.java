package reflectionandannotations.reflections;
import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        // Access private method using Reflection
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);  // Allow access to private method

        // Invoke the method
        int result = (int) method.invoke(calc, 6, 3);

        System.out.println("Result: " + result);
    }
}

