package com.radish.thinking.unit9;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * still do not know what link about read() and s.nextDouble()or s.next()
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {
    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if(count-- ==0)
            return -1;
        String result = Double.toString(next())+" ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNextDouble())
            System.out.println(s.nextInt()+" ");
    }
}
