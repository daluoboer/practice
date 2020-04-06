package com.radish.thinking.unit15;

import java.util.EnumSet;
import java.util.Set;

public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED,Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE,Watercolors.BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1,set2): " + Sets.union(set1,set2));
        Set<Watercolors> subset = Sets.intersection(set1,set2);
        System.out.println("intersection(set1,set2): " + subset);
        System.out.println("difference(set1,set2): " + Sets.difference(set1,set2));
        System.out.println("complement(set1,set2): " + Sets.complement(set1,set2));
    }
}
