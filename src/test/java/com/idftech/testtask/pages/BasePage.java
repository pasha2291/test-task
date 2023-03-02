package com.idftech.testtask.pages;

import com.idftech.testtask.elements.BaseElement;

public abstract class BasePage {
    private BaseElement element;
    private String formName;

    public BasePage(BaseElement element, String formName){
        this.element = element;
        this.formName = formName;
    }

    public String getFormName() { return formName; }

    public boolean isPageOpened() {
        return element.isDisplayed();
    }
}
