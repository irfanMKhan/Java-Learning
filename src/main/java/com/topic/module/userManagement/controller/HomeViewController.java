package com.topic.module.userManagement.controller;

import com.topic.module.userManagement.utility.route.RouteInformation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(RouteInformation.HOME_ROUTE)
public class HomeViewController {


    @GetMapping("")
    public String viewPage(ModelMap model, HttpServletRequest request) {

        model.put("title", "Opportunity List");

        return "index";
    }

}
