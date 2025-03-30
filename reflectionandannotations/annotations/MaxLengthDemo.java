package reflectionandannotations.annotations;



import java.lang.annotation.*;
        import java.lang.reflect.*;

// 1️⃣ Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// 2️⃣ User class with a field-level annotation
class User {

    @MaxLength(10)
    private String username;

    // Constructor with validation logic
    public User(String username) {
        validateLength(username);
        this.username = username;
    }

    // Method to validate the max length using Reflection
    private void validateLength(String username) {
        try {
            Field field = User.class.getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value() + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.println("Username: " + username);
    }
}

public class MaxLengthDemo {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alice123");
            user1.display();

            // This will throw an exception due to max length violation
            User user2 = new User("VeryLongUsername12345");
            user2.display();

        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
