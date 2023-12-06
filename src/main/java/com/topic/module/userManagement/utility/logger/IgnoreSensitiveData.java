package com.topic.module.userManagement.utility.logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"pin", "token", "oldPin", "newPin", "password", "oldPassword", "newPassword"})
public abstract class IgnoreSensitiveData {
}
