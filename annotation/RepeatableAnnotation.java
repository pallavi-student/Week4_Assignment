package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;



    // Define Repeatable Annotation
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(BugReports.class)
    @interface BugReport {
        String description();
    }

    // Container Annotation for Repeated @BugReport
    @Retention(RetentionPolicy.RUNTIME)
    @interface BugReports {
        BugReport[] value();
    }

    // Applying the Repeatable Annotation
    class Software {
        @BugReport(description = "Fix NullPointerException")
        @BugReport(description = "Improve performance in loop")
        public void executeFeature() {
            System.out.println("Executing feature...");
        }
    }

    // Retrieve and Print Multiple Annotations
    public class RepeatableAnnotation {
        public static void main(String[] args) throws Exception {
            Method method = Software.class.getMethod("executeFeature");
            BugReports reports = method.getAnnotation(BugReports.class);

            for (BugReport report : reports.value()) {
                System.out.println("Bug: " + report.description());
            }
        }
    }


