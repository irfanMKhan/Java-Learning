package com.topic.override;

import org.junit.jupiter.api.Test;

public class TestOverride {

    @Test
    public void testSampleCode() {
        ChildClass objectC = new ChildClass();
        ParentClass objectP = new ParentClass();

        objectC.isFunction();
        objectP.isFunction();
    }

}
