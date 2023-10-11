package com.topic.module.userManagement.security.encoder;


import com.google.common.hash.Hashing;
import com.topic.module.userManagement.utility.message.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@RequiredArgsConstructor
public class ApplicationPasswordEncoder implements PasswordEncoder {

    public static String sha512Hash(CharSequence password) {
        return Hashing.sha512().hashString(password, StandardCharsets.UTF_8).toString();
    }

    public String encode(CharSequence rawPassword) {
        if (rawPassword == null || rawPassword.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.PASSWORD_EMPTY);
        } else {
            return Hashing.sha512().hashString(rawPassword, StandardCharsets.UTF_8).toString();
        }
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null || rawPassword.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.PASSWORD_EMPTY);
        } else if (encodedPassword == null || encodedPassword.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ENCODED_PASSWORD_EMPTY);
        } else {
            String matchPassword = sha512Hash(rawPassword);
            return MessageDigest.isEqual(encodedPassword.getBytes(StandardCharsets.UTF_8), matchPassword.getBytes(StandardCharsets.UTF_8));
        }
    }
}
