package com.idftech.testtask.tests;

import com.idftech.testtask.apisteps.ResponseSteps;
import com.idftech.testtask.apisteps.UserSteps;
import com.idftech.testtask.models.User;
import com.idftech.testtask.testutils.UserCredentialsUtil;
import com.idftech.testtask.utils.logger.CustomLogger;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class ApiRegistrationNegativeTests {

    @Test
    public void shortPassword() {
        CustomLogger.info("Start of a short password test.");
        String name = UserCredentialsUtil.getRandomUserName();
        String password = UserCredentialsUtil.getShortPassword();
        User testUser = new User(name, password);
        Response registrationResponse = UserSteps.registerUser(testUser);
        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);
        CustomLogger.info("End of a short password test.");
    }

    @Test
    public void upperCaseMissingPassword() {
        CustomLogger.info("Start of a upper case missing password test.");
        String name = UserCredentialsUtil.getRandomUserName();
        String password = UserCredentialsUtil.getValidRandomPassword().toLowerCase();
        User testUser = new User(name, password);
        Response registrationResponse = UserSteps.registerUser(testUser);
        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);
        CustomLogger.info("End of a upper case missing password test.");
    }

    @Test
    public void lowerCaseMissingPassword() {
        CustomLogger.info("Start of a lower case missing password test.");
        String name = UserCredentialsUtil.getRandomUserName();
        String password = UserCredentialsUtil.getValidRandomPassword().toUpperCase();
        User testUser = new User(name, password);
        Response registrationResponse = UserSteps.registerUser(testUser);
        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);
        CustomLogger.info("End of a lower case missing password test.");
    }

    @Test
    public void digitMissingPassword() {
        CustomLogger.info("Start of a digit missing password test.");
        String name = UserCredentialsUtil.getRandomUserName();
        String password = UserCredentialsUtil.getDigitMissingPassword();
        User testUser = new User(name, password);
        Response registrationResponse = UserSteps.registerUser(testUser);
        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);
        CustomLogger.info("End of a digit missing password test.");
    }

    @Test
    public void specialCharacterMissingPassword() {
        CustomLogger.info("Start of a special character missing password test.");
        String name = UserCredentialsUtil.getRandomUserName();
        String password = UserCredentialsUtil.getSpecialCharacterMissingPassword();
        User testUser = new User(name, password);
        Response registrationResponse = UserSteps.registerUser(testUser);
        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);
        CustomLogger.info("End of a special character missing password test.");
    }

    @Test
    public void validPasswordEmptyName() {
        CustomLogger.info("Start of a valid password empty name test.");
        String name = UserCredentialsUtil.getEmptyCredential();
        String password = UserCredentialsUtil.getValidRandomPassword();
        User testUser = new User(name, password);
        Response registrationResponse = UserSteps.registerUser(testUser);
        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);
        CustomLogger.info("End of a valid password empty name test.");
    }

    @Test
    public void validNameEmptyPassword() {
        CustomLogger.info("Start of a valid name empty password test.");
        String name = UserCredentialsUtil.getRandomUserName();
        String password = UserCredentialsUtil.getEmptyCredential();
        User testUser = new User(name, password);
        Response registrationResponse = UserSteps.registerUser(testUser);
        CustomLogger.info("Step 1. Assert that user is not registered. API response code is 400.");
        ResponseSteps.checkStatusCode(registrationResponse, HttpStatus.SC_BAD_REQUEST);
        CustomLogger.info("End of a valid name empty password test.");
    }
}
