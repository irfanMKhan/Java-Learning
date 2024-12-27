package com.topic.basic.OOP.polymorphism;

public class Main {
    public static void main(String[] args) {

        PolymorphismExample p = new PolymorphismExample();
        PolymorphismExample p2 = new PolymorphismOverrideExample();

        p.methodOverLoad();
        p.methodOverLoad(7);

        /*
            this calls the child method and in the run time it decides which leads to override
         */
        p2.methodOverLoad(7);

    }
}
