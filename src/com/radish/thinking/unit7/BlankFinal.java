package com.radish.thinking.unit7;

class Poppet{
    private int i;
    Poppet(int ii){i = ii;}

    @Override
    public String toString() {
        return "Poppet.i = "+i;
    }
}
public class BlankFinal {
    private final int i = 0;
    private final int j;
    private final Poppet p;

    public BlankFinal() {
        j = 1;
        p = new Poppet(1);
    }

    public BlankFinal(int j) {
        this.j = j;
        p = new Poppet(j);
    }
    int f(final int m){return m+1;}

    @Override
    public String toString() {
        return "i = "+i+", j = "+j+", "+p.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BlankFinal());
        System.out.println(new BlankFinal(47));
    }
}
