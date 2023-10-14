package com.topic.module.userManagement.controller;

import com.topic.module.userManagement.utility.route.RouteInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(RouteInformation.AUTHENTICATION_ROUTE)
public class AuthenticationRestController {
    
}
