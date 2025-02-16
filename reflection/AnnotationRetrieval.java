package com.week4.day6.reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


// Define Custom Annotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface Author {
        String name();
    }

    // Apply Annotation to Class
    @Author(name = "John Doe")
    class Document {
        public void display() {
            System.out.println("This is a document.");
        }
    }

    public class AnnotationRetrieval {
        public static void main(String[] args) {
            try {
                Class<?> clazz = Document.class;

                if (clazz.isAnnotationPresent(Author.class)) {
                    Author author = clazz.getAnnotation(Author.class);
                    System.out.println("Author Name: " + author.name());
                } else {
                    System.out.println("No Author Annotation Found.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


