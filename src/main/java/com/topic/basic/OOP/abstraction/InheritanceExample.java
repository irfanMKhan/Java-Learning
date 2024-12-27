package com.topic.basic.OOP.abstraction;

public interface InheritanceExample {
    /*
        all method in interface are by default public.
        and must be implemented inside the implemented class.
     */
    void displayInterface();

    /*
        after java 8 interface can have their own implementation using default keyword
     */
    default void displayInterfaceImplementation() {
        displayInterface();
    }
    
    void displayClass();

}
