package com.idftech.testtask.apisteps;

import com.idftech.testtask.utils.logger.CustomLogger;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseSteps {

    public static void checkStatusCode(Response response, int statusCode) {
        CustomLogger.info(String.format("ResponseSteps.checkStatusCode(): %d", statusCode));
        response
                .then()
                .statusCode(statusCode);
    }

    public static String getString(Response response) {
        String result = response
                .asString();
        CustomLogger.info(String.format("ResponseSteps.getString: %s", result));
        return result;
    }

    public static <T> T getObject(Response response, Class<T> tClass) {
        CustomLogger.info(String.format("ResponseSteps.getList() : %s", tClass));
        return response
                .body()
                .as(tClass);
    }
}
