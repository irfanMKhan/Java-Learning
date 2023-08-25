package com.topic.leetcode;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[1];
        int currSum = nums[1];
        int temp;
        for (int i = 0; i < nums.length; i++) {
//            temp = Math.max(currSum, currSum + nums[i]);
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
