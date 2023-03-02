package com.idftech.testtask.elements;

import com.idftech.testtask.driver.Driver;
import com.idftech.testtask.utils.logger.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    private By locator;
    private String elementName;

    public BaseElement(By locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
    }

    protected WebElement findElement(By locator){
        return Driver.getDriver().findElement(locator);
    }

    public By getLocator() {
        return locator;
    }

    public String getElementName() {
        return elementName;
    }

    public boolean isDisplayed() {
        CustomLogger.info(elementName + " : isDisplayed()");
        return !Driver.getDriver().findElements(locator).isEmpty();
    }
    public void click() {
        CustomLogger.info(elementName + " : click()");
        findElement(locator).click();
    }

    public String getText() {
        CustomLogger.info(elementName + " : getText()");
        return findElement(locator).getText();
    }
}
