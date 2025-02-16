package com.week4.day6.reflection;
import java.lang.reflect.Field;
import java.util.Map;
    class Persons {
        private String name;
        private int age;

        public void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public class ObjectMapper {
        public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
            try {
                T obj = clazz.getDeclaredConstructor().newInstance();
                for (Map.Entry<String, Object> entry : properties.entrySet()) {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(obj, entry.getValue());
                }
                return obj;
            } catch (Exception e) {
                throw new RuntimeException("Error mapping properties", e);
            }
        }

        public static void main(String[] args) {
            Map<String, Object> data = Map.of("name", "Alice", "age", 25);
            Persons person = toObject(Persons.class, data);
            person.display();
        }
    }


