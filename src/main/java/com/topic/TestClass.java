package com.topic;

import com.topic.MIU.SampleCode;
import com.topic.leetcode.L_5_LongestPalindromicSubstring;

public class TestClass {
    public static void callTestFunction() {

        /*
            override
         */
//        ChildClass objectC = new ChildClass();
//        ParentClass objectP = new ParentClass();
//
//        objectC.isFunction();
//        objectP.isFunction();

        /*
            Leet Code
         */
//        TwoSum twoSum = new TwoSum();
//        int[] a = twoSum.twoSum(new int[]{1, 2, 3, 4, 5}, 6);
//        for (int b : a) {
//            System.out.println(b);
//        }

//        BestTimeTOBuyAndSellStock temp = new BestTimeTOBuyAndSellStock();
//        int a = temp.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        System.out.println(a);

//        ContainsDuplicate temp = new ContainsDuplicate();
//        boolean a = temp.containsDuplicate(new int[]{1, 2, 3, 4});
//        System.out.println(a);

//        ProductOfArrayExceptSelf temp = new ProductOfArrayExceptSelf();
//        int[] a = temp.productExceptSelf(new int[]{1, 2, 3, 4});
//        for (int b : a) {
//            System.out.println(b);
//        }

//        L_53_MaximumSubarray temp = new L_53_MaximumSubarray();
//        int res = temp.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//        System.out.println(res);

//        SampleCode sampleCode = new SampleCode();
//        int res = SampleCode.reverseInteger(-456);
//        System.out.printf(String.valueOf(res));

        L_5_LongestPalindromicSubstring test = new L_5_LongestPalindromicSubstring();
        String a= test.longestPalindrome("bababd");
        System.out.printf(a);
    }
}
