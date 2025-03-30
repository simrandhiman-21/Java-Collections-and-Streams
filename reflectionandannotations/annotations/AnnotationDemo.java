package reflectionandannotations.annotations

import java.lang.annotation.*;
import java.lang.reflect.*;

// 1️Define the @ImportantMethod annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";  // Optional parameter with default value
}

// 2Class with annotated methods
class TaskManager {

    @ImportantMethod(level = "MEDIUM")
    public void processTask() {
        System.out.println("Processing task...");
    }

    @ImportantMethod  // Uses default level: HIGH
    public void completeTask() {
        System.out.println("Completing task...");
    }

    public void regularMethod() {
        System.out.println("This is a regular method.");
    }
}

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        // 3Retrieve and print annotated methods
        Method[] methods = TaskManager.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
                }
        }
    }
}
