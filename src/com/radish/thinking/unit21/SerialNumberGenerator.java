package com.radish.thinking.unit21;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/21
 */

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    //给这儿加个synchronized就行啦！
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
