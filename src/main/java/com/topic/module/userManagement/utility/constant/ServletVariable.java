package com.topic.module.userManagement.utility.constant;


import com.topic.module.userManagement.utility.route.RouteInformation;

public class ServletVariable {

    public static final String[] IGNORE_URLS = {
            "/*/*.html",
            "/*/*.css",
            "/*.css",
            "/*/*.png",
            "/*/*.jpg",
            "/*/*.gif",
            "/*/*.ico",
            "/*.ico",
            "/*/*.woff2",
            "/*/*.woff",
            "/*/*.map",
            "/*/*.ttf",
            "/*/*.js",
            "/*.js",
            "/logout",
            "/login",
    };
    public static final String[] OPEN_URLS = {
            "/api/auth/**",
            RouteInformation.HOME_ROUTE
    };

    public static final String[] NEED_AUTHORIZATION_URLS = {
            "/api/auth/registration",
    };

    public static final String[] TOKEN_FILTER_OPEN_URLS = {
            RouteInformation.AUTHENTICATION_ROUTE + RouteInformation.SIGN_IN_ROUTE,
            RouteInformation.HOME_ROUTE,
            "/(.*).ico",
    };
    public static final String SERVLET_MESSAGE = "message";

}
