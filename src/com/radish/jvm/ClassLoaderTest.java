package com.radish.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description ClassLoaderTest
 * @Author Radish
 * @Date 2020-09-24 11:02
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name/*.substring(name.lastIndexOf(".") + 1)*/ + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }

            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }
        };

//        Object obj = myLoader.loadClass("com.radish.jvm.ClassLoaderTest").newInstance();
//        Object obj = myLoader.loadClass("com.radish.examine.Baowen").newInstance();
//        Object obj = myLoader.loadClass("F:\\workspace\\practice\\src\\com\\radish\\examine\\Baowen").newInstance();
        Object obj = ClassLoaderTest.class.getClassLoader().loadClass("com.radish.examine.Baowen").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.radish.jvm.ClassLoaderTest);
    }
}
