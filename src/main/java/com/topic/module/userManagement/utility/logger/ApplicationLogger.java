package com.topic.module.userManagement.utility.logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.topic.module.userManagement.model.payload.request.LoginRequest;
import com.topic.module.userManagement.utility.type.Enum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationLogger {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();

        objectMapper.addMixIn(LoginRequest.class, IgnoreSensitiveData.class);

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        objectMapper.registerModule(new JavaTimeModule());
    }

    private static String getObjectAsString(Object object) {
        String objectToString;
        try {
            objectToString = objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            objectToString = object.toString();
        }
        return objectToString;
    }

    public static void logInfo(Enum.LogType logType, String purpose, String details) {
        try {
            log.info(logType.name() + " :: " + purpose + " | " + details);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void logInfo(Enum.LogType logType, String purpose, Object object) {
        try {
            log.info(logType.name() + " :: " + purpose + " | " + getObjectAsString(object));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
