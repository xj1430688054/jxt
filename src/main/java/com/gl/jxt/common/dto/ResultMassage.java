package com.gl.jxt.common.dto;

import org.apache.commons.lang3.StringUtils;

public class ResultMassage {

    public static final String OPERATE_SUCCESS = "operate_success";
    public static final String OPERATE_ERROR = "operate_error";
    public static final String PARAM_ERROR = "param_error";
    public static final String USERNAME_NOT_EMPTY = "username_not_empty";
    public static final String NAME_NOT_EMPTY = "name_not_empty";
    public static final String PASSWORD_NOT_EMPTY = "password_not_empty";
    public static final String LOGIN_NAME_NOT_EMPTY = "login_name_not_empty";
    public static final String TOKEN_NOT_EMPTY = "token_not_empty";
    public static final String LOGIN_INFO_WRONG = "login_info_wrong";
    public static final String UN_LOGIN = "un_login";
    public static final String ACCOUNT_IS_DISABLED = "account_is_disabled";
    public static final String USERNAME_EXISTS = "username_exists";
    public static final String USERNAME_LENGTH_ONLY_BE = "username_length_only_be";
    public static final String ADMIN_NOT_EXISTS = "admin_not_exists";
    public static final String USER_NOT_EXISTS = "user_not_exists";

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
