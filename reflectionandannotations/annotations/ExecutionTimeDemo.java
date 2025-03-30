package reflectionandannotations.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

// 1️⃣ Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// 2️⃣ Class with annotated methods
class MathOperations {

    @LogExecutionTime
    public void add() {
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }

    @LogExecutionTime
    public void multiply() {
        long product = 1;
        for (int i = 1; i <= 1000; i++) {
            product *= i;
        }
        System.out.println("Product: " + product);
    }

    public void regularMethod() {
        System.out.println("This is a regular method.");
    }
}

public class ExecutionTimeDemo {

    // 3️⃣ Method to measure execution time using Reflection
    public static void measureExecutionTime(Object obj, Method method) throws Exception {
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Execution time of " + method.getName() + ": " + duration + " nanoseconds\n");
    }

    public static void main(String[] args) throws Exception {
        MathOperations mathOps = new MathOperations();

        // 4️⃣ Retrieve methods and measure time
        Method[] methods = MathOperations.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                measureExecutionTime(mathOps, method);
            }
        }
    }
}

