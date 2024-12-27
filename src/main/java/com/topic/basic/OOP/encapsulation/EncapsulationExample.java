package com.topic.basic.OOP.encapsulation;

public class EncapsulationExample {

    public static int encapsulation(int a, int b) {
        return a + b;
    }

    private static int encapsulation(int a, int b, int c) {
        return a + b + c;
    }

    protected static int encapsulationAccessPrivate(int a, int b, int c) {
        return encapsulation(a, b, c);
    }

}
