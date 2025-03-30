package reflectionandannotations.reflections;


import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Name";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicallyCreateObject {
    public static void main(String[] args) throws Exception {
        // Create an instance dynamically using Reflection
        Constructor<Student> constructor = Student.class.getDeclaredConstructor();
        Student student = constructor.newInstance();

        // Invoke method to display the name
        student.display();
    }
}

