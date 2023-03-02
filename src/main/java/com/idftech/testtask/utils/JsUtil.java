package com.idftech.testtask.utils;

import com.idftech.testtask.driver.Driver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;

@UtilityClass
public class JsUtil {
    private static final String scrollDownScript = "window.scrollTo(0, document.body.scrollHeight)";
    private static JavascriptExecutor js;

    public static void scrollDown() {
        js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript(scrollDownScript);
    }
}
