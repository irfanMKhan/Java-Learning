package com.topic;

import com.topic.leetcode.ProductOfArrayExceptSelf;
import com.topic.override.ChildClass;
import com.topic.override.ParentClass;
import com.topic.test.MIU;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);

        ChildClass objectC = new ChildClass();
        ParentClass objectP = new ParentClass();

        objectC.isFunction();
        objectP.isFunction();

        callLeetCodeFunction();

    }

    public static void callLeetCodeFunction() {

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

        ProductOfArrayExceptSelf temp = new ProductOfArrayExceptSelf();
        int[] a = temp.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int b : a) {
            System.out.println(b);
        }

        MIU ab = new MIU();
        int v = ab.sumOfEvenOdd(new int[]{3,4});
    }

}
