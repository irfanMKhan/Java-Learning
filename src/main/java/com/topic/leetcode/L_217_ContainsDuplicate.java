package com.topic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L_217_ContainsDuplicate {
    public boolean containsDuplicate_Map(int[] nums) {
        Map<Integer, Integer> history = new HashMap<>();
        for (int num : nums) {
            if (history.containsKey(num)) {
                return true;
            }
            history.put(num, 1);
        }
        return false;
    }

    public boolean containsDuplicate_Sort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
