package com.topic.module.userManagement.utility.constant;


import com.topic.module.userManagement.utility.route.RouteInformation;

public class ServletVariable {

    public static final String[] OPEN_URLS = {
            "/api/auth/**"
    };
    public static final String[] TOKEN_FILTER_OPEN_URLS = {
            RouteInformation.AUTHENTICATION_ROUTE + RouteInformation.SIGN_IN_ROUTE
    };
    public static final String SERVLET_MESSAGE = "message";

}
