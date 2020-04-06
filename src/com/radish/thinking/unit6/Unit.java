package com.radish.thinking.unit6;

public class Unit {
    public void unitPublic(){
        System.out.println("Here is public");
    }
    protected void unitProtected(){
        System.out.println("I am protected!");
    }
    private void unitPrivate(){
        System.out.println("I am private!");
    }

    public static void main(String[] args) {
        Unit unit = new Unit();
        unit.unitPublic();
        unit.unitProtected();
        unit.unitPrivate();
    }
}
