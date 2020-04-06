package com.radish.thinking.unit19;

import java.util.EnumSet;

public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        System.out.println("add BATHROOM: \n\t" + points);
        points.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
        System.out.println("\naddAll EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN): \n\t" + points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
        System.out.println("\n1.allOf(AlarmPoints.class) 2.removeAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN)): \n\t" + points);
        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1,AlarmPoints.OFFICE4));
        System.out.println("\nremoveAll(EnumSet.range(AlarmPoints.OFFICE1,AlarmPoints.OFFICE4)): \n\t" + points);
        points = EnumSet.complementOf(points);//取其余的
        System.out.println("\nEnumSet.complementOf(points): \n\t" + points);
    }
}
