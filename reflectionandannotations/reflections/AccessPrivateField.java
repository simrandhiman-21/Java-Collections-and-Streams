package reflectionandannotations.reflections;
import java.lang.reflect.Field;

    class Person {
        private int age = 25;  // Private field
    }

    public class AccessPrivateField {
        public static void main(String[] args) throws Exception {
            Person person = new Person();

            // Access the private field using Reflection
            Field field = Person.class.getDeclaredField("age");
            field.setAccessible(true);  // Allow access to private field

            // Modify the field value
            field.set(person, 30);

            // Retrieve and print the modified value
            System.out.println("Modified Age: " + field.get(person));
        }
    }

