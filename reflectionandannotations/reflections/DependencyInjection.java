package reflectionandannotations.reflections;

import java.lang.annotation.*;
        import java.lang.reflect.*;

// Custom @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Service classes
class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}

class Car {
    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving!");
    }
}

// Simple Dependency Injection (DI) container
class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);  // Allow access to private fields
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) throws Exception {
        Car car = new Car();

        // Perform dependency injection
        DIContainer.injectDependencies(car);

        // Use the injected dependency
        car.drive();
    }
}

