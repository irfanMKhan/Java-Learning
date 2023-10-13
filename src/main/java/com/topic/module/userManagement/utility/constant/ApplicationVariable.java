package com.topic.module.userManagement.utility.constant;

public class ApplicationVariable {
    public static final Boolean USE_DEFAULT_PASSWORD = true;
    public static final String DEFAULT_PASSWORD = "reddotIT@123";
    public static final Integer USER_IP_LOCKOUT_DURATION = 5;
    public static final Integer USER_WRONG_PASSWORD_MAX_ATTEMPT = 4;
    public static final Integer PASSWORD_MINIMUM_LENGTH = 10;
    public static final Integer PASSWORD_VALIDITY = 60000;
    public static final Integer PASSWORD_MINIMUM_COMPLEXITY = 3;
    public static final Integer PASSWORD_ALERT_AFTER = 15;
    public static final String[] PASSWORD_RESTRICTED_WORDS = {"robi", "airtel", "admin", "administrator"};
    public static final Integer PASSWORD_MINIMUM_RESTRICTED_HISTORY = 5;

    public static final String BULK_RESPONSE_CONTENT_TYPE = "text/csv";

    public static final String TREND_REPORT_EXCEL_FILE_NAME = "TrendReport.xlsx";
    public static final String BULK_RESPONSE_HEADER_NAME = "Content-Disposition";
    public static final String BULK_RESPONSE_HEADER_VALUE = "attachment; file=bulk_corporate_form.csv";

    public static final String EXPORT_RESPONSE_HEADER_VALUE = "attachment; filename=";

    public static final String EXPORT_RESPONSE_MEDIA_PARSE_TYPE = "application/vnd.ms-excel";
    public static final String BULK_RESPONSE_WRITE_VALUE = "IMSI,IMEI,MSISDN,KCP_DOCID,OWNER_DOCID";

    public static final String DATABASE_SCHEMA_NAME = "DEIR";
}
