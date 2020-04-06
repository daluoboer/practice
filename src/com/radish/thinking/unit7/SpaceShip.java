package com.radish.thinking.unit7;

public class SpaceShip extends SpaceShipControls {
    private String name;

    @Override
    public String toString() {
        return name;
    }

    public SpaceShip(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip("NSEA Protector");
        spaceShip.forward(100);
    }
}
