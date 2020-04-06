package com.radish.easyCoding.unit6;

import java.util.HashMap;

public class TreeMapRepeat {
    public static void main(String[] args) {
//        TreeMap map = new TreeMap();
        HashMap map = new HashMap();
        //HashMap 依照HashCode()和equals()对key去重
        //TreeMap 依靠Comparable或者Comparator来实现key的去重
        map.put(new Key(),"value one");
        map.put(new Key(),"value two");
        System.out.println(map.size());
    }
}

class Key implements Comparable<Key> {
    @Override
    public int compareTo(Key o) {
        return -1;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
