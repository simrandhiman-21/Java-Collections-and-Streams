package reflectionandannotations.annotations;


import java.lang.annotation.*;
        import java.lang.reflect.*;

// 1️⃣ Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// 2️⃣ Class using the annotation
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

public class TaskInfoAPI {
    public static void main(String[] args) throws Exception {
        // 3️⃣ Retrieve annotation details using Reflection
        Method method = TaskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        } else {
            System.out.println("No annotation found.");
        }
    }
}

