package com.week4.day6.reflection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
    interface Greeting {
        void sayHello();
    }

    class GreetingImpl implements Greeting {
        public void sayHello() {
            System.out.println("Hello, World!");
        }
    }

    class LoggingProxy implements InvocationHandler {
        private final Object target;

        public LoggingProxy(Object target) {
            this.target = target;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Executing: " + method.getName());
            return method.invoke(target, args);
        }
    }

    public class ProxyExample {
        public static void main(String[] args) {
            Greeting original = new GreetingImpl();
            Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                    Greeting.class.getClassLoader(),
                    new Class[]{Greeting.class},
                    new LoggingProxy(original)
            );

            proxyInstance.sayHello();
        }
    }


