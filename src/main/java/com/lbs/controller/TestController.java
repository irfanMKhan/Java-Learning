package com.lbs.controller;

import com.lbs.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {

    @Autowired
    private TestRepo testRepo;

    @GetMapping("/get")
    public String getUser() {
        String userName = testRepo.findByIdAndName(Long.valueOf(1), "test").getClass().getName();
        return userName;
    }
}
