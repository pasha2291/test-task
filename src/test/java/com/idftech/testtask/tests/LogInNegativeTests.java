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

public class LogInNegativeTests extends BaseTest {

    @Test
    public void registeredUserLowerCasePassword() {
        CustomLogger.info("Start of a registered user lower case password test.");

        String userName = UserCredentialsUtil.getRandomUserName();
        String userPassword = UserCredentialsUtil.getValidRandomPassword();

        User testUser = new User(userName, userPassword);
        Response registrationResponse = UserSteps.registerUser(testUser);

        CustomLogger.info("Step 1. Assert that user registered properly. API response code is 201.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_CREATED);

        BookStorePage bookStorePage = new BookStorePage();
        LogInPage logInPage = bookStorePage.logInButtonClick();

        testUser.setPassword(userPassword.toLowerCase());
        logInPage.logInUser(testUser);

        CustomLogger.info("Step 2. Check that user is not logged in.");
        Response isUserAuthorizedResponse = UserSteps.authorizedUser(testUser);
        String authorizationResult = ResponseSteps.getString(isUserAuthorizedResponse);

        CustomLogger.info("Assert that API Authorized response is false.");
        Assert.assertNotEquals(authorizationResult, Boolean.TRUE.toString(), "Test user should not be authorized!");

        CustomLogger.info("Assert that log in error message appeared on the web page.");
        Assert.assertTrue(logInPage.isLogInFailMessageDisplayed(), "Log in error message should be displayed on the web page!");

        CustomLogger.info("End of a registered user lower case password  test.");
    }

    @Test
    public void registeredUserUpperCasePassword() {
        CustomLogger.info("Start of a registered user upper case password test.");

        String userName = UserCredentialsUtil.getRandomUserName();
        String userPassword = UserCredentialsUtil.getValidRandomPassword();

        User testUser = new User(userName, userPassword);
        Response registrationResponse = UserSteps.registerUser(testUser);

        CustomLogger.info("Step 1. Assert that user registered properly. API response code is 201.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_CREATED);

        BookStorePage bookStorePage = new BookStorePage();
        LogInPage logInPage = bookStorePage.logInButtonClick();

        testUser.setPassword(userPassword.toUpperCase());
        logInPage.logInUser(testUser);

        CustomLogger.info("Step 2. Check that user is not logged in.");
        Response isUserAuthorizedResponse = UserSteps.authorizedUser(testUser);
        String authorizationResult = ResponseSteps.getString(isUserAuthorizedResponse);

        CustomLogger.info("Assert that API Authorized response is false.");
        Assert.assertNotEquals(authorizationResult, Boolean.TRUE.toString(), "Test user should not be authorized!");

        CustomLogger.info("Assert that log in error message appeared on the web page.");
        Assert.assertTrue(logInPage.isLogInFailMessageDisplayed(), "Log in error message should be displayed on the web page!");

        CustomLogger.info("End of a registered user upper case password test.");
    }

    @Test
    public void registeredUserWrongUserName() {
        CustomLogger.info("Start of a registered user wrong user name test.");

        String userName = UserCredentialsUtil.getRandomUserName();
        String userPassword = UserCredentialsUtil.getValidRandomPassword();

        User testUser = new User(userName, userPassword);
        Response registrationResponse = UserSteps.registerUser(testUser);

        CustomLogger.info("Step 1. Assert that user registered properly. API response code is 201.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_CREATED);

        BookStorePage bookStorePage = new BookStorePage();
        LogInPage logInPage = bookStorePage.logInButtonClick();

        testUser.setUserName(UserCredentialsUtil.getRandomUserName());
        logInPage.logInUser(testUser);

        CustomLogger.info("Step 2. Check that user is not logged in.");
        Response isUserAuthorizedResponse = UserSteps.authorizedUser(testUser);
        String authorizationResult = ResponseSteps.getString(isUserAuthorizedResponse);

        CustomLogger.info("Assert that API Authorized response is false.");
        Assert.assertNotEquals(authorizationResult, Boolean.TRUE.toString(), "Test user should not be authorized!");

        CustomLogger.info("Assert that log in error message appeared on the web page.");
        Assert.assertTrue(logInPage.isLogInFailMessageDisplayed(), "Log in error message should be displayed on the web page!");

        CustomLogger.info("End of a registered user wrong user name test.");
    }

    @Test
    public void unregisteredUser() {
        CustomLogger.info("Start of a unregistered user test.");

        String userName = UserCredentialsUtil.getRandomUserName();
        String userPassword = UserCredentialsUtil.getShortPassword();

        User testUser = new User(userName, userPassword);
        Response registrationResponse = UserSteps.registerUser(testUser);

        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);

        BookStorePage bookStorePage = new BookStorePage();
        LogInPage logInPage = bookStorePage.logInButtonClick();

        testUser.setPassword(userPassword.toLowerCase());

        testUser.setUserName(UserCredentialsUtil.getRandomUserName());
        logInPage.logInUser(testUser);

        CustomLogger.info("Step 2. Check that user is not logged in.");
        Response isUserAuthorizedResponse = UserSteps.authorizedUser(testUser);
        String authorizationResult = ResponseSteps.getString(isUserAuthorizedResponse);

        CustomLogger.info("Assert that API Authorized response is false.");
        Assert.assertNotEquals(authorizationResult, Boolean.TRUE.toString(), "Test user should not be authorized!");

        CustomLogger.info("Assert that log in error message appeared on the web page.");
        Assert.assertTrue(logInPage.isLogInFailMessageDisplayed(), "Log in error message should be displayed on the web page!");

        CustomLogger.info("End of a unregistered user test.");
    }
}
