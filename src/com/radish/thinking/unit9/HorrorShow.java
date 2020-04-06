package com.radish.thinking.unit9;

import java.math.BigDecimal;

interface Monster{
    void menaxe();
}
interface DangerousMonster extends Monster{
    void destory();
}
interface Lethal{
    void kill();
}
class DragonZilla implements DangerousMonster{
    @Override
    public void menaxe() {

    }

    @Override
    public void destory() {

    }
}
interface Vampire extends DangerousMonster,Lethal{
    void drinkBlood();
}
class VeryBadVampire implements Vampire{
    @Override
    public void menaxe() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}
public class HorrorShow {
    static void u(Monster b){b.menaxe();}
    static void v(DangerousMonster d){
        d.menaxe();
        d.destory();
    }
    static void w(Lethal l){l.kill();}

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
        System.out.println(BigDecimal.valueOf(0.01).compareTo(BigDecimal.valueOf(0.1)));
    }
}
