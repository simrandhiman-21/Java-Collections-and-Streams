package reflectionandannotations.reflections;

import java.lang.reflect.Field;

class Person {
    public String name = "Alice";
    public int age = 25;
    public boolean isActive = true;
}

public class ObjectToJson {

    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);  // Allow access to private fields
            json.append("\"")
                    .append(fields[i].getName())
                    .append("\": \"")
                    .append(fields[i].get(obj))
                    .append("\"");

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person();

        String json = toJson(person);
        System.out.println("JSON: " + json);
    }
}
