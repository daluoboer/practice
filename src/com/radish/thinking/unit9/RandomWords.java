package com.radish.thinking.unit9;

import java.nio.*;
import java.util.*;

/**
 * 咦，这个实现Readable的用法之前老师好像讲过耶~当时还迷迷瞪瞪的，感觉很惊奇，完全不知道发生了什么，原来是实现了接口~不过还是有点蒙，为啥要跟Scanner关联起来？
 * 哦！因为Scanner的构造器可以接受一个Readable类型的参数，但是为啥需要这个参数呢？蒙...Scanner接受了这个参数之后又可以用来干啥呢？
 * 今天晚上回去吃饺子吧！妈妈给我包的饺子还没有吃完~
 * 喝了袋奶，撑了...
 *
 */
public class RandomWords implements Readable {
    private static Random rand = new Random(47);
    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int count;
    public RandomWords(int count){this.count = count;}
    @Override
    public int read(CharBuffer cb) {
        if(count-- == 0)return -1;
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for(int i = 0;i<4;i++){
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()) System.out.println(s.next());
    }
}
