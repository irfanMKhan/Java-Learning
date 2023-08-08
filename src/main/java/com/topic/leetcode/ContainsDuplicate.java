package com.topic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> history = new HashMap<>();
        for (int num : nums) {
            if (history.containsKey(num)) {
                return true;
            }
            history.put(num, 1);
        }
        return false;
    }
}
