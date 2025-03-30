package reflectionandannotations.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

// 1️⃣ Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// 2️⃣ Class with a computationally expensive method
class ExpensiveService {

    // Cache map to store results
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int factorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for: " + n);
            return cache.get(n);
        }

        System.out.println("Computing factorial for: " + n);
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        cache.put(n, result);
        return result;
    }
}

public class CacheDemo {

    // 3️⃣ Method to invoke the annotated method with caching logic
    public static Object invokeWithCache(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            ExpensiveService service = (ExpensiveService) obj;
            return method.invoke(service, args);
        } else {
            return method.invoke(obj, args);
        }
    }

    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();

        // Invoke the method multiple times
        System.out.println("Factorial of 5: " + invokeWithCache(service, "factorial", 5));
        System.out.println("Factorial of 5: " + invokeWithCache(service, "factorial", 5));  // Cached result
        System.out.println("Factorial of 6: " + invokeWithCache(service, "factorial", 6));
        System.out.println("Factorial of 6: " + invokeWithCache(service, "factorial", 6));  // Cached result
    }
}

