package com.topic.miu;

import org.junit.jupiter.api.Test;

public class TestMIU {

    @Test
    public void testSampleCode() {
        SampleCode sampleCode = new SampleCode();
        int res = SampleCode.reverseInteger(-456);
        System.out.printf(String.valueOf(res));
    }

}
