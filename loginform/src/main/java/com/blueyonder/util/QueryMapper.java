package com.blueyonder.util;

public interface QueryMapper {

    public static final String GET_ALL_USERS = "select username from userdata;";
    public static final String GET_USER_BY_NAME = "select * from userdata where username = ?;";

    public static final String VALID_USERNAME_AND_PASSWORD = "select * from userdata where username = ? and password = ?;";
}
