package com.idftech.testtask.utils;

import com.idftech.testtask.driver.Driver;
import com.idftech.testtask.utils.logger.CustomLogger;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BrowserUtil {
    public static void goToURL(String url) {
        CustomLogger.info("BrowserUtil.goToURL(): " + url);
        Driver.getDriver().navigate().to(url);
    }

    public void pageScrollDown() {
        CustomLogger.info("BrowserUtil.scrollDown()");
        JsUtil.scrollDown();
    }
}
