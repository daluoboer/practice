package com.radish.thinking.unit10;

import java.math.BigDecimal;

public class Parcel1 {
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){return label;}
    }
    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
        System.out.println(c.value());
    }
    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
        System.out.println(BigDecimal.valueOf(1).multiply(null).add(BigDecimal.valueOf(3).multiply(BigDecimal.valueOf(4))));
    }
}
