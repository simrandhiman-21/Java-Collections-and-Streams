package reflectionandannotations.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

// 1️⃣ Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// 2️⃣ User class with annotated fields
class User {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class JsonSerializer {

    // 3️⃣ Method to convert object to JSON string using Reflection
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, Object> jsonMap = new HashMap<>();

        for (Field field : fields) {
            field.setAccessible(true);  // Access private fields

            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj));
            } else {
                jsonMap.put(field.getName(), field.get(obj));
            }
        }

        // Build JSON string
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": ");
            if (entry.getValue() instanceof String) {
                json.append("\"").append(entry.getValue()).append("\", ");
            } else {
                json.append(entry.getValue()).append(", ");
            }
        }

        // Remove trailing comma and close JSON
        if (json.length() > 1) {
            json.setLength(json.length() - 2);
        }
        json.append("}");

        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Alice", 25);

        // Convert User object to JSON
        String json = toJson(user);
        System.out.println("JSON: " + json);
    }
}

