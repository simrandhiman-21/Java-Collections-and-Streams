package reflectionandannotations.reflections;

import java.lang.reflect.Field;
import java.util.Map;

class Person {
    public String name;
    public int age;
}

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);  // Allow access to private fields
            field.set(obj, entry.getValue());
        }

        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = Map.of(
                "name", "Alice",
                "age", 25
        );

        Person person = toObject(Person.class, properties);

        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);
    }
}
