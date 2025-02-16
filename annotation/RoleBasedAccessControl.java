package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

    @Retention(RetentionPolicy.RUNTIME)
    @interface RoleAllowed {
        String value();
    }
    class Users {
        private String role;

        public Users(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }
    class SecureService {
        @RoleAllowed("ADMIN")
        public void adminTask() {
            System.out.println("Admin task executed successfully!");
        }
    }
    public class RoleBasedAccessControl {
        public static void main(String[] args) throws Exception {
            Users adminUser = new Users("ADMIN");
            Users normalUser = new Users("USER");

            SecureService service = new SecureService();

            checkAccess(service, "adminTask", adminUser);  // Allowed
            checkAccess(service, "adminTask", normalUser); // Denied
        }

        private static void checkAccess(Object obj, String methodName, Users user) throws Exception {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (!user.getRole().equals(requiredRole)) {
                    System.out.println("Access Denied for user with role: " + user.getRole());
                    return;
                }
            }
            method.invoke(obj);
        }
    }


