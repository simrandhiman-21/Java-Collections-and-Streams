package reflectionandannotations.annotations;

import java.lang.annotation.*;
        import java.lang.reflect.*;

// 1️⃣ Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// 2️⃣ Class with annotated methods
class Project {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void login() {
        System.out.println("Login feature...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        System.out.println("Database optimization...");
    }

    @Todo(task = "Add logout functionality", assignedTo = "Charlie", priority = "LOW")
    public void logout() {
        System.out.println("Logout feature...");
    }
}

public class TodoDemo {
    public static void main(String[] args) throws Exception {
        // 3️⃣ Retrieve and print all pending tasks
        Method[] methods = Project.class.getDeclaredMethods();

        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("---------------------");
            }
        }
    }
}
