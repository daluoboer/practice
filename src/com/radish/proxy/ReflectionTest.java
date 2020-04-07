package com.radish.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/25
 */

public class ReflectionTest {
    public static void main(String[] args) {
        try {
            Class<HelloWorldImpl> helloWorldClass = HelloWorldImpl.class;
            HelloWorldImpl helloWorld1 = new HelloWorldImpl();
            Class<? extends HelloWorldImpl> aClass = helloWorld1.getClass();
            Class<?> helloWorldImpl = Class.forName("com.radish.proxy.HelloWorldImpl");

            try {
                HelloWorldImpl helloWorld = (HelloWorldImpl) helloWorldImpl.newInstance();
                System.out.println(helloWorld);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

//            System.exit(0);

            System.out.println("helloWorldImpl.getName() : " + helloWorldImpl.getName() );
            System.out.println("helloWorldImpl.getFields(): ");
            Field[] fields = helloWorldImpl.getFields();
            System.out.println("helloWorldImpl.getMethods(): ");
            Method[] methods = helloWorldImpl.getMethods();
            for (Method method : methods)
                System.out.println("\t" + method);
            System.out.println("helloWorldImpl.getInterfaces(): ");
            Class<?>[] interfaces = helloWorldImpl.getInterfaces();
            for (Class c : interfaces)
                System.out.println("\t" + c);
            System.out.println("helloWorldImpl.getDeclaredMethods(): ");
            Method[] declaredMethods = helloWorldImpl.getDeclaredMethods();
            for (Method m : declaredMethods)
                System.out.println("\t" + m);
            System.out.println("helloWorldImpl.toGenericString(): " + helloWorldImpl.toGenericString());

            System.out.println("helloWorldImpl.getClassLoader(): " + helloWorldImpl.getClassLoader());
            System.out.println("helloWorldImpl.getConstructor(): ");
            Constructor<?>[] constructors = helloWorldImpl.getConstructors();
            for (Constructor c : constructors) {
                System.out.println("\t" + c);
                try {
                    Object o = c.newInstance();
                    System.out.println(o.getClass());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }


        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }
}
