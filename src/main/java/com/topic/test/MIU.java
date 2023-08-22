package com.topic.test;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.Map;

public class MIU {

    public int middleElement(int[] listInt) {
        int len = listInt.length;
        if (len % 2 == 0) {
            return 0;
        } else {
            int a = len / 2;
            for (int b = 0; b < len; b++) {
                if (a == b)
                    continue;
                if (listInt[b] <= listInt[a]) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public int sumOfEvenOdd(int[] array) {
        Map<Integer, Integer> integerMap = new HashMap<>();

        for (int a = 0; a < array.length; a++) {
            if (array[a] % 2 == 0) {
                if (integerMap.containsKey(0))
                    integerMap.put(0, integerMap.get(0) + array[a]);
                else
                    integerMap.put(0, array[a]);
            } else {
                if (integerMap.containsKey(0))
                    integerMap.put(1, integerMap.get(1) + array[a]);
                else
                    integerMap.put(1, array[a]);
            }
        }

        if (integerMap.containsKey(1) && integerMap.containsKey(0))
            return integerMap.get(1) - integerMap.get(0);
        if (integerMap.containsKey(0))
            return integerMap.get(0);
        if (integerMap.containsKey(1))
            return integerMap.get(1);

        return 0;
    }

}
