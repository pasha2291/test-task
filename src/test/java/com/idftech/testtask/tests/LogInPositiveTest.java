package com.idftech.testtask.tests;

import com.idftech.testtask.apisteps.ResponseSteps;
import com.idftech.testtask.apisteps.UserSteps;
import com.idftech.testtask.models.User;
import com.idftech.testtask.pages.BookStorePage;
import com.idftech.testtask.pages.LogInPage;
import com.idftech.testtask.testutils.UserCredentialsUtil;
import com.idftech.testtask.utils.logger.CustomLogger;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInPositiveTest extends BaseTest {

    @Test
    public void positiveLogInTest() {
        CustomLogger.info("Start of a positive log in test.");

        String userName = UserCredentialsUtil.getRandomUserName();
        String userPassword = UserCredentialsUtil.getValidRandomPassword();

        User testUser = new User(userName, userPassword);
        Response registrationResponse = UserSteps.registerUser(testUser);

        CustomLogger.info("Step 1. Assert that user registered properly. API response code is 201.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_CREATED);

        BookStorePage bookStorePage = new BookStorePage();
        LogInPage logInPage = bookStorePage.logInButtonClick();
        logInPage.logInUser(testUser);

        CustomLogger.info("Step 2. Check that user is logged in.");
        Response isUserAuthorizedResponse = UserSteps.authorizedUser(testUser);
        String authorizationResult = ResponseSteps.getString(isUserAuthorizedResponse);

        CustomLogger.info("Assert that API Authorized response is true.");
        Assert.assertEquals(authorizationResult, Boolean.TRUE.toString(), "Test user should be authorized!");

        CustomLogger.info("Assert that User name has appeared at the top of the web page and it equals to registered user name.");
        Assert.assertEquals(testUser.getUserName(), bookStorePage.getLoggedInUserName(),
                "Test user name should be equal to the name that has appeared on the web page!");

        CustomLogger.info("End of a positive log in test.");
    }
}
