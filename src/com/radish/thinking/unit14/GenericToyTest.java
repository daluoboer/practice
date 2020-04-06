package com.radish.thinking.unit14;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
//        Class<Toy> up2 = ftClass.getSuperclass();
        Object object = up.newInstance();
    }
}
