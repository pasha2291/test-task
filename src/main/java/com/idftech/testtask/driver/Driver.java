package com.idftech.testtask.driver;

import com.idftech.testtask.utils.ConfigDataManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

@UtilityClass
public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null){
            String browserName = ConfigDataManager.getBrowserName();
            List<String> options = ConfigDataManager.getBrowserOptions();
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments(options);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Browser unknown or is not defined!");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
