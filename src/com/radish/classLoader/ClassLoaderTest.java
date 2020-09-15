package com.radish.classLoader;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/25
 */

public class ClassLoaderTest{

    public static void main(String[] args) throws Exception{
        for (;;) {
            for (int i = 0; i < 9600000; i++) {
            }
            Thread.sleep(1000);
        }

        /*ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
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
        };

        Object obj = myLoader.loadClass("com.radish.classLoader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);*/
    }
}

class T {

}
