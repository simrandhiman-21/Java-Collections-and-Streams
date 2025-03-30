package reflectionandannotations.annotations;

import java.lang.reflect.Method;

class MathOperations {
    public void add() {
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }

    public void multiply() {
        long product = 1;
        for (int i = 1; i <= 1000; i++) {
            product *= i;
        }
        System.out.println("Product: " + product);
    }
}

public class ExecutionTimer {
    public static void main(String[] args) throws Exception {
        MathOperations mathOps = new MathOperations();

        // Measure execution time dynamically using Reflection
        for (Method method : MathOperations.class.getDeclaredMethods()) {
            System.out.println("\nExecuting: " + method.getName());

            long startTime = System.nanoTime();
            method.invoke(mathOps);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println("Execution time: " + duration + " nanoseconds");
        }
    }
}

