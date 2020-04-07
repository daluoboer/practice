package com.radish.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/25
 */

public class HelloWorldHandler implements InvocationHandler {
    private Object obj;

    public HelloWorldHandler(Object obj) {
        super();
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        doBefore();
        result = method.invoke(obj,args);
        doAfter();
        return result;
    }

    private void doBefore(){
        System.out.println("before");
    }
    private void doAfter(){
        System.out.println("after");
    }
}
