package com.radish.thinking.unit16;

import java.util.Arrays;
import java.util.Collections;

public class StringSorting {
    public static void main(String[] args) {
        String[] sa = {"Hi","Yes","What","like","love","hate","beautiful","wonderful","cute","mouse","ear","eye","nose","hair","face"};
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
//        Collections.sort(Arrays.asList(sa));
        System.out.println(Arrays.toString(sa));
    }
}
