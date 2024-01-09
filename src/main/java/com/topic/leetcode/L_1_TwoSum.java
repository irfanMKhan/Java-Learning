package com.topic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L_1_TwoSum {
    public int[] twoSum_Map(int[] nums, int target) {

        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(target - nums[i])) {
                return new int[]{dict.get(target - nums[i]), i};
            }
            dict.put(nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum_Regular(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
