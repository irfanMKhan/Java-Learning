package com.topic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(target - nums[i])) {
                return new int[]{dict.get(target - nums[i]), i};
            }
            dict.put(nums[i], i);
        }
        return new int[]{};
    }
}
