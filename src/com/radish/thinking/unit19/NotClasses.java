package com.radish.thinking.unit19;

enum LikeClasses {
    WINKEN {void behavior() {
        System.out.println("Behavior1");
    }},
    BLINKEN {void behavior() {
        System.out.println("Behavior2");
    }},
    NOD {void behavior() {
        System.out.println("Behavior3");
    }};
    abstract void behavior();
}
public class NotClasses {

}
