package com.topic.immutable;

import lombok.Getter;

/*
    Java 8
 */
@Getter
public final class ImmutableClass {

    private final String name;
    private final String age;

    public ImmutableClass(String name, String age) {
        this.name = name;
        this.age = age;
    }

}
