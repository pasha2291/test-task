package com.idftech.testtask.tests;

import com.idftech.testtask.driver.Driver;
import com.idftech.testtask.utils.BrowserUtil;
import com.idftech.testtask.utils.ConfigDataManager;
import com.idftech.testtask.utils.logger.CustomLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final String initialPageUrl = String.format("%s/books", ConfigDataManager.getBaseUrl());

    @BeforeMethod
    public void initializeTestScenario() {
        CustomLogger.info("initializeTestScenario()");
        Driver.getDriver();
        BrowserUtil.goToURL(initialPageUrl);
    }

    @AfterMethod
    public void finalizeTestScenario() {
        Driver.quitDriver();
        CustomLogger.info("finalizeTestScenario()");
    }
}
