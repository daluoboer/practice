package com.radish.thinking.unit8;

class Characteristic{
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic "+s);
    }
    protected void diapose(){
        System.out.println("disposing Characteristic "+s);
    }
}
class Description{
    private String s;

    public Description(String s) {
        this.s = s;
        System.out.println("Creating Description "+s);
    }
    protected void dispose(){
        System.out.println("disposing Descripton "+s);
    }
}
class LivingCreature{
    private Characteristic p = new Characteristic("is alive");
    private Description t = new Description("Basic Living Creature");

    public LivingCreature() {
        System.out.println("LivingCreature()");
    }
    protected void dispose(){
        System.out.println("LivingCreature dispose");
        t.dispose();
        p.diapose();
    }
}
class Animal extends LivingCreature{
    private Characteristic p = new Characteristic("has heart");
    private Description t = new Description("Animal not Vegetable");

    public Animal() {
        System.out.println("Animal()");
    }
    protected void dispose(){
        System.out.println("Animal dispose");
        t.dispose();
        p.diapose();
        super.dispose();
    }
}
class Amphibian extends Animal{
    private Characteristic p = new Characteristic("can I live in water");
    private Description t = new Description("Both water and land");

    public Amphibian() {
        System.out.println("Amphibian()");
    }
    protected void dispose(){
        System.out.println("Amphibian dispose");
        t.dispose();
        p.diapose();
        super.dispose();
    }
}
public class Frog extends Amphibian {
    private Characteristic p = new Characteristic("Croaks");
    private Description t = new Description("Eats bugs");

    public Frog() {
        System.out.println("Frog()");
    }
    protected void dispose(){
        System.out.println("Frog dispose");
        t.dispose();
        p.diapose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Bye!");
        frog.dispose();
    }
}
