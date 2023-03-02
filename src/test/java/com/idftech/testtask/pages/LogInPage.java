package com.idftech.testtask.pages;

import com.idftech.testtask.elements.Button;
import com.idftech.testtask.elements.InputField;
import com.idftech.testtask.elements.Label;
import com.idftech.testtask.models.User;
import com.idftech.testtask.utils.BrowserUtil;
import org.openqa.selenium.By;

public class LogInPage extends BasePage {
    private static final Label LOG_IN_LABEL = new Label(By.xpath("//div[@class='main-header' and contains(text(), 'Login')]"), "log in label");
    private static final Label LOG_IN_ERROR_LABEL = new Label(By.id("name"), "log in error label");
    private static final InputField USER_NAME_INPUT_FIELD = new InputField(By.id("userName"), "user name input field");
    private static final InputField PASSWORD_INPUT_FIELD = new InputField(By.id("password"), "password input field");
    private static final Button LOG_IN_BUTTON = new Button(By.id("login"), "log in button");

    public LogInPage() {
        super(LOG_IN_LABEL, "Log in page");
    }

    public void logInUser(User user) {
        BrowserUtil.pageScrollDown();
        USER_NAME_INPUT_FIELD.clearSendKeys(user.getUserName());
        PASSWORD_INPUT_FIELD.clearSendKeys(user.getPassword());
        LOG_IN_BUTTON.click();
    }

    public boolean isLogInFailMessageDisplayed() {
        return LOG_IN_ERROR_LABEL.isDisplayed();
    }
}
