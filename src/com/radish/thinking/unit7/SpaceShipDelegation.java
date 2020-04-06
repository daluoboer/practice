package com.radish.thinking.unit7;

public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }
    public void back(int velocity){controls.back(velocity);}
    public void down(int velocity){controls.down(velocity);}
    public void forward(int velocity){controls.forward(velocity);}
    public void left(int v){controls.left(v);}
    public void right(int v){controls.right(v);}
    public void turboBoost(){controls.turboBoost();}
    public void up(int v){controls.up(v);}

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }
}
