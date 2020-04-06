package com.radish.thinking.unit9;

interface CanFight {
    void fight();
}
interface CanSwim{
    void swim();
}
interface CanFly{
    void fly();
}
interface CanClimb{
    void climb();
}
class ActionCharacter{
    public void fight(){
        System.out.println("class-fight()");
    }
}
class Hero extends ActionCharacter implements CanFight,CanSwim,CanFly,CanClimb{
    @Override
    public void swim() {
        System.out.println("swim()");
    }

    @Override
    public void fly() {
        System.out.println("fly()");
    }

    @Override
    public void climb() {
        System.out.println("climb()");
    }
}
public class Adventure{
    public static void t(CanFight x){x.fight();}
    public static void u(CanSwim x){x.swim();}
    public static void v(CanFly x){x.fly();}
    public static void w(ActionCharacter x){x.fight();}
    public static void x(CanClimb x){x.climb();}

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
        x(h);
    }
}
