package com.week4.day6.reflection;
    import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

    // Custom @Inject Annotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface Inject {}

    // Service to be Injected
    class EmailService {
        public void sendEmail() {
            System.out.println("Email Sent!");
        }
    }

    // Class with Dependency
    class UserController {
        @Inject
        private EmailService emailService;

        public void sendUserEmail() {
            emailService.sendEmail();
        }
    }

    // Dependency Injection Container
    public class DependencyInjector {
        public static void injectDependencies(Object obj) {
            try {
                Class<?> clazz = obj.getClass();
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        field.setAccessible(true);
                        field.set(obj, field.getType().getDeclaredConstructor().newInstance());
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("Dependency Injection Failed", e);
            }
        }

        public static void main(String[] args) {
            UserController controller = new UserController();
            injectDependencies(controller);
            controller.sendUserEmail();
        }
    }


