package com.radish.thinking.unit8;

public class Cycle {
    void ride(){
        System.out.print("I am riding ");
    }

    static void youRide(Cycle cycle){
        cycle.ride();
    }
    public static void main(String[] args) {
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        youRide(unicycle);
        youRide(bicycle);
        youRide(tricycle);
    }
}
class Unicycle extends Cycle{
    @Override
    void ride() {
        super.ride();
        System.out.println("Unicycle~~~~~~~");
    }
}
class Bicycle extends Cycle{
    @Override
    void ride() {
        super.ride();
        System.out.println("Bicycle~~~~~~~");
    }
}
class Tricycle extends Cycle{
    @Override
    void ride() {
        super.ride();
        System.out.println("Tricycle~~~~~~");
    }
}
