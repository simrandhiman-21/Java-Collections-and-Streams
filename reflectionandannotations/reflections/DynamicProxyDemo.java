package reflectionandannotations.reflections;
import java.lang.reflect.*;

interface Greeting {
    void sayHello();
    void sayGoodbye();
}

// Implementation of the interface
class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello!");
    }

    public void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}

// Logging Proxy Handler
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        // Create the original object
        Greeting greeting = new GreetingImpl();

        // Create the proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(greeting)
        );

        // Invoke methods through the proxy
        proxyInstance.sayHello();
        proxyInstance.sayGoodbye();
    }
}

