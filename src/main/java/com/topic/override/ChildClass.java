package com.topic.override;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChildClass extends ParentClass {

    public void isFunction() {
        System.out.println("From Child");
    }

}
