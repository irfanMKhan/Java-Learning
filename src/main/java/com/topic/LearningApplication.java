package com.topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.HashMap;

@SpringBootApplication
public class LearningApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int length = a.length;
        System.out.println(length);

        int[] b;
        b = new int[length + 1];
        length = b.length;

        b = a;

        length = b.length;

        HashMap<String, Integer> hm
                = new HashMap<String, Integer>();

        // Adding mappings to HashMap
        // using put() method
        hm.put("GeeksforGeeks", 54);
        hm.put("A computer portal", 80);
        hm.put("For geeks", 82);
        final int[] max = {0};

        hm.forEach((k, v) -> {
            System.out.println(k + " : " + (v + 10));
            if (v > max[0]) {
                max[0] = v;
            }
        });
        System.out.println(max[0]);

        SpringApplication.run(LearningApplication.class, args);
    }

    String a() {
        return null;
    }

    int a(int b) {
        return 0;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LearningApplication.class);
    }

}
