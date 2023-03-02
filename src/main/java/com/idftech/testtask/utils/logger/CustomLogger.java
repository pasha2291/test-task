package com.idftech.testtask.utils.logger;

import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@UtilityClass
public class CustomLogger {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void info(String message){
        LOGGER.log(Level.INFO, message);
    }

    public static void logResponse(Response response) {
        info(String.format("Response: getStatusCode(): %s; getStatusLine(): %s; getBody(): %s", response.getStatusCode(),
                response.getStatusLine(), response.getBody().prettyPrint()));
    }

    public static void logRequest(FilterableRequestSpecification requestSpec) {
        info(String.format("Request specification: getMethod(): %s; getURI(): %s; getHeaders(): %s;", requestSpec.getMethod(),
                requestSpec.getURI(), requestSpec.getHeaders()));
    }
}
