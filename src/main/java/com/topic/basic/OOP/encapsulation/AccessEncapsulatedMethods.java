package com.topic.basic.OOP.encapsulation;

public class AccessEncapsulatedMethods {

    public static void main(String[] args) {
        /*
            public method can be accessed from anywhere.
         */
        System.out.println(EncapsulationExample.encapsulation(1,2));

        /*
            cannot access as it is protected
         */
//        System.out.println(EncapsulationExample.encapsulation(1,2,3));

        /*
            as the below system are in the same package protected method can be access.
            From outside the package it can not be accessed.
            through the open method we can access private method.
         */
        System.out.println(EncapsulationExample.encapsulationAccessPrivate(1,2,3));
    }
}
