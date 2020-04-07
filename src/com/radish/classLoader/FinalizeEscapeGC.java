package com.example.classLoader;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/28
 */

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive() {
        System.out.println("yes,I am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();
        /*呀，看来手动调一次finalize不影响JVM垃圾收集时候的调用噢*/
        try {
            SAVE_HOOK.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Thread.sleep(500);
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:(");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:(");
        }
    }
}
