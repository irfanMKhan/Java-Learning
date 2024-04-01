package com.topic.module.userManagement.utility.constant;


import com.topic.module.userManagement.utility.route.RouteInformation;
import com.topic.module.userManagement.utility.route.RouteMatcher;

public class ServletVariable {

    public static final String[] NEED_AUTHORIZATION_URLS = {
            RouteInformation.REGISTRATION_ROUTE
    };

    public static final String[] TOKEN_FILTER_OPEN_URLS = {
            RouteInformation.AUTHENTICATION_ROUTE + RouteInformation.SIGN_IN_ROUTE,
            RouteInformation.HOME_ROUTE,
            RouteInformation.SWAGGER_ROUTE,
            RouteInformation.SWAGGER_API_DOCS_ROUTE
    };

    public static final String[] TOKEN_FILTER_MATCH_OPEN_URLS = {
            RouteMatcher.ICO_MATCHER
    };

    public static final String[] OPEN_URLS = {
            RouteInformation.REGISTRATION_ROUTE,
            RouteInformation.HOME_ROUTE
    };

    public static final String SERVLET_MESSAGE = "message";

}
