package com.idftech.testtask.elements;

import com.idftech.testtask.utils.logger.CustomLogger;
import org.openqa.selenium.By;

public class InputField extends BaseElement {

    public InputField(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void clearSendKeys(String text){
        CustomLogger.info(this.getElementName() + ".sendText(): " + text);
        findElement(this.getLocator()).clear();
        findElement(this.getLocator()).sendKeys(text);
    }
}
