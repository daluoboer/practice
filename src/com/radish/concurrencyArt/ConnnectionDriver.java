package com.radish.concurrencyArt;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @description ConnnectionDriver
 * @Author Radish
 * @Date 2020-06-23 18:53:17
 */

public class ConnnectionDriver {
    static class ConnectHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnnectionDriver.class.getClassLoader(),new Class<?>[]{Connection.class},new ConnectHandler());
    }
}
