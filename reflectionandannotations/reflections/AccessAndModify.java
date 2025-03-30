package reflectionandannotations.reflections;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
}

public class AccessAndModify {
    public static void main(String[] args) throws Exception {
        // Access the static field using Reflection
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);  // Allow access to private field

        // Modify the static field value
        field.set(null, "NEW_API_KEY");

        // Print the modified value
        System.out.println("Modified API_KEY: " + field.get(null));
    }
}

