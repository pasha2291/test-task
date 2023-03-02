package com.idftech.testtask.apisteps;

import com.idftech.testtask.constants.Endpoints;
import com.idftech.testtask.models.User;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserSteps extends BaseSteps {

    public static Response registerUser(User user) {
        return baseRequest()
                .body(user)
                .post(Endpoints.USER_REGISTER);
    }

    public static Response authorizedUser(User user) {
        return baseRequest()
                .body(user)
                .post(Endpoints.USER_AUTHORIZED);
    }
}
