package com.radish.thinking.unit17;

import java.util.*;

public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);
//        c.add("one");
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next());
//        lit.add("one");
        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));
        Map<String,String> m = Collections.unmodifiableMap(new HashMap<String,String>(Countries.capitals(6)));
        System.out.println(m);
//        m.put("Ralph","Howdy!");
        Map<String,String> sm = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(6)));
    }
}
