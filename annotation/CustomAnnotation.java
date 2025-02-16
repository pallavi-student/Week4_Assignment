package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class CustomAnnotation {
    @Retention(RetentionPolicy.RUNTIME)
    @interface TaskInfo {
        String priority() default "Medium";
        String assignedTo();
    }
    class TaskManager {
        @TaskInfo(priority = "High", assignedTo = "Alice")
        public void completeTask() {
            System.out.println("Task completed.");
        }
    }
    public class CustomAnnotationExample {
        public static void main(String[] args) throws Exception {
            Method method = TaskManager.class.getMethod("completeTask");
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }

}
