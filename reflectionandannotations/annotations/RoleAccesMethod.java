package reflectionandannotations.annotations;


import java.lang.annotation.*;
        import java.lang.reflect.*;

// 1️⃣ Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// 2️⃣ Service class with restricted methods
class SecureService {

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed!");
    }

    public void publicTask() {
        System.out.println("Public task executed!");
    }
}

public class RoleAccesMethod {

    // 3️⃣ Method to simulate role-based access
    public static void executeMethod(Object obj, String methodName, String userRole) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (roleAllowed.value().equals(userRole)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                method.invoke(obj);  // No restriction, execute normally
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureService service = new SecureService();

        // Simulate user roles
        System.out.println("\nTrying as ADMIN:");
        executeMethod(service, "adminTask", "ADMIN");  // Allowed

        System.out.println("\nTrying as USER:");
        executeMethod(service, "adminTask", "USER");   // Access Denied

        System.out.println("\nTrying public method:");
        executeMethod(service, "publicTask", "USER");  // No restriction
    }
}

