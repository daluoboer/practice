package com.radish.thinking.unit15;

import com.radish.thinking.unit14.Person;
import com.radish.thinking.unit14.PetCreator;

import java.util.List;
import java.util.Map;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends PetCreator>> map = New.map();
    }
}
