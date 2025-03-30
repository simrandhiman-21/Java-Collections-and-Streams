package reflectionandannotations.reflections;

import java.lang.annotation.*;
        import java.lang.reflect.*;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

// Apply annotation to a class
@Author(name = "John Doe")
class Book {
    // Class code here
}

public class RetriveAnnotation {
    public static void main(String[] args) {
        // Get the class object
        Class<Book> obj = Book.class;

        // Check and retrieve annotation
        if (obj.isAnnotationPresent(Author.class)) {
            Author author = obj.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No annotation found.");
        }
    }
}
