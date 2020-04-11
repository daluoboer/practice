package com.radish.thinking.unit21;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/21
 */

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public int next() {
        /*递增非原子性操作！所以这是有问题滴*/
        ++currentEvenValue;
//        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
