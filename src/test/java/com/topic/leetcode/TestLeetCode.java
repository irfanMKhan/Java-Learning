package com.topic.leetcode;

import org.junit.jupiter.api.Test;

public class TestLeetCode {

    @Test
    public void test_1_TwoSum() {
        L_1_TwoSum twoSum = new L_1_TwoSum();
        int[] a = twoSum.twoSum_Map(new int[]{1, 2, 3, 4, 5}, 6);
        for (int b : a) {
            System.out.println(b);
        }

        a = twoSum.twoSum_Regular(new int[]{1, 2, 3, 4, 5}, 6);
        for (int b : a) {
            System.out.println(b);
        }
    }

    @Test
    public void test_5_LongestPalindromicSubstring() {

        L_5_LongestPalindromicSubstring temp = new L_5_LongestPalindromicSubstring();
        String res = temp.longestPalindrome("abcb");
        System.out.println(res);
    }

    @Test
    public void test_53_MaximumSubArray() {

        L_53_MaximumSubArray temp = new L_53_MaximumSubArray();
        int res = temp.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(res);
    }


    @Test
    public void test_121_BestTimeToBuyAndSellStock() {
        L_121_BestTimeToBuyAndSellStock temp = new L_121_BestTimeToBuyAndSellStock();
        int a = temp.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(a);
    }

    @Test
    public void test_217_ContainsDuplicate() {

        L_217_ContainsDuplicate temp = new L_217_ContainsDuplicate();
        boolean a = temp.containsDuplicate_Map(new int[]{1, 2, 3, 4});
        System.out.println(a);

        a = temp.containsDuplicate_Sort(new int[]{1, 2, 3, 4});
        System.out.println(a);
    }

    @Test
    public void test_238_ProductOfArrayExceptSelf() {

        L_238_ProductOfArrayExceptSelf temp = new L_238_ProductOfArrayExceptSelf();
        int[] a = temp.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int b : a) {
            System.out.println(b);
        }
    }

}
