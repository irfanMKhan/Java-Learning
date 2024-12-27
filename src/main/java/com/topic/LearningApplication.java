package com.topic;

import com.topic.leetcode.L_1_TwoSum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class LearningApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        L_1_TwoSum twoSum = new L_1_TwoSum();
        twoSum.twoSum_Map(new int[]{1, 2}, 3);
        SpringApplication.run(LearningApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LearningApplication.class);
    }

}
