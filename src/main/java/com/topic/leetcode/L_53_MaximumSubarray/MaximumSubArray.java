package com.topic.leetcode.L_53_MaximumSubarray;

public class MaximumSubArray {
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
