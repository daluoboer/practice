package com.radish.thinking.unit17;

import com.radish.thinking.unit15.Generator;
import com.radish.thinking.unit16.CountingGenerator;
import com.radish.thinking.unit16.RandomGenerator;

import java.util.Iterator;

class Letters implements Generator<Pair<Integer,String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number<size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(),11));
        System.out.println(MapData.map(new CountingGenerator.Character(),new RandomGenerator.String(3),8));
        System.out.println(MapData.map(new CountingGenerator.Character(),"Value",6));
        System.out.println(MapData.map(new Letters(),new RandomGenerator.String(3)));
        System.out.println(MapData.map(new Letters(),"Pop"));
    }
}
