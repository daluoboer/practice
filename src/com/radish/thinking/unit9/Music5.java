package com.radish.thinking.unit9;

import com.radish.thinking.unit8.Note;

interface Instrument1{
    int VALUE = 5;
    void play(Note n);
    void adjust();
}

class Wind1 implements Instrument1{
    @Override
    public void play(Note n) {
        System.out.println(this+".play() "+n);
    }

    @Override
    public void adjust() {
        System.out.println(this+".adjust() ");
    }

    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion1 implements Instrument1{
    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    public void play(Note n) {
        System.out.println(this+".play() "+n);
    }

    @Override
    public void adjust() {
        System.out.println(this+".adjust()");
    }
}

class Stringed1 implements Instrument1{
    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void play(Note n) {
        System.out.println(this+".play() "+n);
    }

    @Override
    public void adjust() {
        System.out.println(this+".adjust()");
    }
}

class Brass1 extends Wind1{
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind1 extends Wind1{
    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class Music5 {
    static void tune(Instrument1 i){i.play(Note.MIDDLE_C);}
    static void tuneAll(Instrument1[] e){for(Instrument1 i:e) tune(i);}

    public static void main(String[] args) {
        Instrument1[] orchestra = {
                new Wind1(),
                new Percussion1(),
                new Stringed1(),
                new Brass1(),
                new Woodwind1()
        };
        tuneAll(orchestra);
    }
}
