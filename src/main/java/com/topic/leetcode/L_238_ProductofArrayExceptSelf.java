package com.topic.leetcode;

import java.util.Arrays;

public class L_238_ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int[] result = new int[nums.length];

        Arrays.fill(result, 1);

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }

        return result;
    }

}
