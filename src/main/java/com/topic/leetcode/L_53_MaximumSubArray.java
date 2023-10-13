package com.topic.leetcode;

public class L_53_MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[1];
        int currSum = nums[1];
        for (int num : nums) {
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
