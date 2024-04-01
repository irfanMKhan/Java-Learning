package com.topic.module.userManagement.utility.route;

public class RouteInformation {
    public static final String HOME_ROUTE = "/home";

    public static final String SWAGGER_ROUTE = "/swagger-ui";
    public static final String SWAGGER_API_DOCS_ROUTE ="/v3/api-docs";
    public static final String API_ROUTE = "/api";
    public static final String AUTHENTICATION_ROUTE = API_ROUTE + "/auth";

    public static final String TREND_REPORT_ROUTE = "/trend_report";

    public static final String DATABASE_STATUS_ROUTE = "/db_status";

    public static final String EXPORT_TREND_REPORT = "/export_trend_report";

    public static final String LAST_TREND_REPORT_DATE_ROUTE = TREND_REPORT_ROUTE + "/last_date";

    public static final String DATABASE_MONITOR_ROUTE = "/monitor";

    public static final String REGISTRATION_ROUTE = "/registration";
    public static final String SIGN_IN_ROUTE = "/sign_in";
    public static final String CHANGE_PASSWORD_ROUTE = "/change_password";

    public static final String CORPORATE_ACCOUNT_ROUTE = API_ROUTE + "/corporate/account";
    public static final String CORPORATE_NUMBER_ROUTE = API_ROUTE + "/corporate/number";

    public static final String ADD_ROUTE = "/add";
    public static final String ADD_BULK_ROUTE = ADD_ROUTE + "/bulk";
    public static final String EDIT_ROUTE = "/edit";
    public static final String DELETE_ROUTE = "/delete";

    public static final String CORPORATE_LIST_ROUTE = "/list";

    public static final String CORPORATE_ACCOUNT_DATATABLE_ROUTE = CORPORATE_LIST_ROUTE + "/datatable";
    public static final String CORPORATE_NUMBER_DATATABLE_ROUTE = CORPORATE_LIST_ROUTE + "/datatable";

    public static final String BULK_TEMPLATE_ROUTE = "/bulk/template.csv";
}
