package com.radish.proxy;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/25
 */

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void hello() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        HelloWorldImpl helloWorld = new HelloWorldImpl();
        HelloWorldHandler helloWorldHandler = new HelloWorldHandler(helloWorld);
        HelloWorld proxy = (HelloWorld)Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), helloWorldHandler);
        proxy.hello();
        System.out.println(proxy.getClass());
    }
}
