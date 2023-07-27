package com.topic.servlet.controller;

import com.topic.servlet.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/get")
    public String getUser() {
        String userName = testRepository.findByIdAndName(Long.valueOf(1), "test").getClass().getName();
        return userName;
    }
}
