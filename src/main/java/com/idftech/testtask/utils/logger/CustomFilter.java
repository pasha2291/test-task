package com.idftech.testtask.utils.logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class CustomFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext filterContext) {
        Response response = filterContext.next(requestSpec, responseSpec);
        CustomLogger.logRequest(requestSpec);
        CustomLogger.logResponse(response);
        return response;
    }
}
