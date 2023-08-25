package com.topic;

import com.topic.leetcode.L_53_MaximumSubarray.MaximumSubArray;

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

        MaximumSubArray temp = new MaximumSubArray();
        int res = temp.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}
