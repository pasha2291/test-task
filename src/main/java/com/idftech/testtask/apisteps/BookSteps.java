package com.idftech.testtask.apisteps;

import com.idftech.testtask.constants.Endpoints;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookSteps extends BaseSteps {

    public static Response getBookList() {
        return baseRequest()
                .get(Endpoints.GET_BOOK_LIST);
    }
}
