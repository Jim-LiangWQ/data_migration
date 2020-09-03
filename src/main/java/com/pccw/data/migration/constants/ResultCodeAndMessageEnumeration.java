package com.pccw.data.migration.constants;

import lombok.Getter;
import lombok.ToString;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:33
 **/
@Getter
@ToString
public enum ResultCodeAndMessageEnumeration {

    RESULT_OK("0", "success"),
    RESULT_INVALID_PARAMETERS("400", "invalid parameters"),
    RESULT_NOT_FOUND("404", "not found, invalid request info"),
    RESULT_UNKNOWN_ERROR("999", "unknown error"),
    RESULT_NOT_FOUND_RECORD_IN_DB("1000", "not found record in database"),
    RESULT_FAILED_INSERT_RECORD_IN_DB("1001", "failed insert record in database"),
    RESULT_FAILED_UPDATE_RECORD_IN_DB("1002", "failed update record in database"),
    RESULT_FAILED_DELETE_RECORD_IN_DB("1003", "failed delete record in database"),
    RESULT_FAILED_QUERY_RECORD_IN_DB("1004", "failed query record in database"),
    RESULT_FAILED_PASSWORD_INCORRECT("2001", "password is incorrect."),
    RESULT_FAILED_PASSWORD_INCORRECT_FIVE_TIMES("2002", "Password error for five consecutive times, the user has been locked."),
    RESULT_FAILED_PASSWORD_DECRYPT_FAILED("2003", "Failed to decrypt password."),
    RESULT_FAILED_LOGIN_FAILED("3001", "login failed cause by the user not exist or has been locked or pending."),
    RESULT_OAUTH_CLIENT_NOT_FOUND("A001", "oauth client not found"),
    RESULT_USER_HAS_NOT_BEEN_ASSIGNED_ROLE("A002", "user has not been assigned role"),
    RESULT_ROLE_NOT_FOUND("A003", "role not found"),
    RESULT_PERMISSION_DENIED("A004", "permission denied");

    private final String resultCode;
    private final String resultMessage;

    ResultCodeAndMessageEnumeration(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }


}
