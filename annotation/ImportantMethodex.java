package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
    // Define Custom Annotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface ImportantMethod {
        String level() default "HIGH";
    }
    class Service {

        @ImportantMethod(level = "CRITICAL")
        public void processPayment() {
            System.out.println("Processing payment...");
        }

        @ImportantMethod
        public void generateReport() {
            System.out.println("Generating report...");
        }

        public void normalMethod() {
            System.out.println("This is a normal method.");
        }
    }
    public class ImportantMethodex {
        public static void main(String[] args) {
            Method[] methods = Service.class.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Important Method: " + method.getName() + ", Level: " + annotation.level());
                }
            }
        }
    }


