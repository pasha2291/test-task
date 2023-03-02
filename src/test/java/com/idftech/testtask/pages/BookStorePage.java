package com.idftech.testtask.pages;

import com.idftech.testtask.driver.Driver;
import com.idftech.testtask.elements.Button;
import com.idftech.testtask.elements.Label;
import com.idftech.testtask.utils.ConditionalWaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BookStorePage extends BasePage {
    private static final Label BOOK_STORE_LABEL = new Label(By.xpath("//div[@class='main-header' and contains(text(), 'Book Store')]"),
            "book store label");
    private static final Label BOOK_TITLE_LABEL = new Label(By.xpath("//div[@class='action-buttons']//a"), "book title label");
    private static final Label LOGGED_IN_USER_NAME_LABEL = new Label(By.id("userName-value"), "logged in user name label");
    private static final Button LOG_IN_BUTTON = new Button(By.id("login"), "log in button");

    public BookStorePage() {
        super(BOOK_STORE_LABEL, "Book store page");
    }

    public LogInPage logInButtonClick() {
        LOG_IN_BUTTON.click();
        return new LogInPage();
    }

    public List<String> getBookTitleList() {
        List<WebElement> bookList = Driver.getDriver().findElements(BOOK_TITLE_LABEL.getLocator());
        return bookList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public String getLoggedInUserName() {
        ConditionalWaitUtil.waitToBePresent(LOGGED_IN_USER_NAME_LABEL);
        return LOGGED_IN_USER_NAME_LABEL.getText();
    }
}
