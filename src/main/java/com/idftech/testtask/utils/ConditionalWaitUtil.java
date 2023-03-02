package com.idftech.testtask.utils;

import com.idftech.testtask.driver.Driver;
import com.idftech.testtask.elements.BaseElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@UtilityClass
public class ConditionalWaitUtil {
    private static final int SECONDS = ConfigDataManager.getWaitDurationInSeconds();
    private static final Duration DURATION = Duration.ofSeconds(SECONDS);

    public static void waitToBePresent(BaseElement element) {
        new WebDriverWait(Driver.getDriver(), DURATION).until(driver -> driver.findElement(element.getLocator()));
    }
}
