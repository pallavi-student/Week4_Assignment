package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
    @Retention(RetentionPolicy.RUNTIME)
    @interface CacheResult {}


    class MathService {
        private static final Map<Integer, Integer> cache = new HashMap<>();

        @CacheResult
        public int expensiveComputation(int number) {
            if (cache.containsKey(number)) {
                System.out.println("Returning cached result for " + number);
                return cache.get(number);
            }

            System.out.println("Computing for " + number + "...");
            int result = number * number; // Example expensive computation
            cache.put(number, result);
            return result;
        }
    }
    public class CustomCaching {
        public static void main(String[] args) throws Exception {
            MathService service = new MathService();

            invokeCachedMethod(service, "expensiveComputation", 5);
            invokeCachedMethod(service, "expensiveComputation", 5);
            invokeCachedMethod(service, "expensiveComputation", 10);
        }
        private static void invokeCachedMethod(Object obj, String methodName, int arg) throws Exception {
            Method method = obj.getClass().getMethod(methodName, int.class);
            if (method.isAnnotationPresent(CacheResult.class)) {
                System.out.println("Result: " + method.invoke(obj, arg));
            }
        }
    }


