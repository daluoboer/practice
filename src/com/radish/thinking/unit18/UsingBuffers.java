package com.radish.thinking.unit18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer) {
        /*这里的CharBuffer只是一个视图，在调用缓冲器上相对的get或者put之后，position位置发生改变*/
        buffer.mark();
        char c1 = buffer.get();
        char c2 = buffer.get();
        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
        System.out.println("before reset:"+buffer);
        buffer.reset();
        /*reset方法把position的值设为mark的值*/
        System.out.println("AFTER RESET:"+buffer);
        buffer.put(c2).put(c1).put((char)1);
        System.out.println("after put:"+buffer);
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        /*rewind把position设置到缓冲器的开始位置*/
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }
}
