package com.idftech.testtask.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoints {
    private static final String ACCOUNT = "/Account/v1/%s";
    private static final String BOOK_STORE = "/BookStore/v1/%s";
    public static final String USER_REGISTER = String.format(ACCOUNT, "User");
    public static final String USER_AUTHORIZED = String.format(ACCOUNT, "Authorized");
    public static final String GET_BOOK_LIST = String.format(BOOK_STORE, "Books");
}
