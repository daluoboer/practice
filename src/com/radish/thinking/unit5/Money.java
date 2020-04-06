package com.radish.thinking.unit5;

public class Money {
    MoneyEnum moneyEnum;

    public Money(MoneyEnum moneyEnum) {
        this.moneyEnum = moneyEnum;
    }

    public void describe() {
        switch (moneyEnum) {
            case YIMAO:
                System.out.println("这是一毛钱。");
                break;
            case LIANGMAO:
                System.out.println("这是两毛钱。");
                break;
            case WUMAO:
                System.out.println("这是五毛钱。");
                break;
            case YIKUAI:
                System.out.println("这是一块钱。");
                break;
            case LIANGKUAI:
                System.out.println("这是两块钱。");
                break;
            case WUKUAI:
                System.out.println("这是五块钱。");
                break;
            default:
                System.out.println("这是多少钱？？？？？");
        }
    }

    public static void main(String[] args) {
        for (MoneyEnum m : MoneyEnum.values())
            System.out.println(m + ", ordinal " + m.ordinal());
        Money m1 = new Money(MoneyEnum.LIANGKUAI),
                m2 = new Money(MoneyEnum.LIANGMAO),
                m3 = new Money(MoneyEnum.WUKUAI),
                m4 = new Money(MoneyEnum.WUMAO),
                m5 = new Money(MoneyEnum.YIKUAI),
                m6 = new Money(MoneyEnum.YIMAO);
        System.out.println();
        m1.describe();m2.describe();m3.describe();m4.describe();m5.describe();m6.describe();
    }
}
