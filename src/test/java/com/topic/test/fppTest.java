package com.topic.test;

import com.topic.miu.SampleCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class fppTest {

    @Test
    public void testIs121() {
        fpp fpp = new fpp();

        int res = fpp.is121(new int[]{1,1,1,2,2,1,2,2,1,1,1});
        System.out.printf(String.valueOf(res));
    }

    @Test
    public void testIs123() {
        fpp fpp = new fpp();

        int res = fpp.is123(new int[]{1,2,3,1,2,3});
        System.out.printf(String.valueOf(res));
    }

    @Test
    public void testf() {
        fpp fpp = new fpp();

        char[] res = fpp.f(new char[]{'a','b','c','d'},1,3);
        System.out.printf(String.valueOf(res));
    }

    @Test
    public void testisConcatenatedSum() {
        fpp fpp = new fpp();

        int res = fpp.isConcatenatedSum(198,2);
        System.out.printf(String.valueOf(res));
    }

    @Test
    public void testencodeNumber() {
        fpp fpp = new fpp();

        int[] res = fpp.encodeNumber(6936);
        System.out.printf(String.valueOf(res));
    }

}