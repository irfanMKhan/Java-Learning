package com.topic.immutable;

import lombok.Getter;

/*
    Java 14 Above
 */
@Getter
public record ImmutableRecord(String name, String age) {

}
