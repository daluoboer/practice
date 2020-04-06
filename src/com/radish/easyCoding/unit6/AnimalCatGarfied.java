package com.radish.easyCoding.unit6;

import java.util.ArrayList;
import java.util.List;
public class AnimalCatGarfied {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Garfied> garfieds = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        garfieds.add(new Garfied());

        List<? extends Cat> extendsCatFromCat = cats;
        List<? extends Cat> extendsCatFromGarfieds = garfieds;
//        List<? extends Cat> extendsCatFromAnimal = animals;

        List<? super Cat> superCatFromAnimal = animals;
        List<? super Cat> superCatFromCat = cats;
//        List<? super Cat> superCatFromGarfieds = garfieds;

//        extendsCatFromCat.add(new Cat());
//        extendsCatFromGarfieds.add(new Cat());
//        extendsCatFromGarfieds.add(new Garfied());

//        superCatFromAnimal.add(new Animal());
        superCatFromAnimal.add(new Cat());
        superCatFromAnimal.add(new Garfied());
//        superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfied());

        Cat cat = extendsCatFromCat.get(0);
        Object object = superCatFromCat.get(0);
    }
}

class Animal {}

class Cat extends Animal {}

class Garfied extends Cat {}