package com.idftech.testtask.utils;

import com.idftech.testtask.utils.fileprocessing.JSONCustomParser;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ConfigDataManager {
    private static final String CONFIG_FILE = "config.json";
    private static final String BROWSER_NAME = "browserName";
    private static final String BASE_URL = "baseUrl";
    private static final String WAIT_DURATION = "waitDuration";
    private static final String OPTIONS = "options";

    private static String getPropertyFromConfigFile(String propertyName) {
        return JSONCustomParser.getElementByNameFromResPath(CONFIG_FILE, propertyName);
    }

    public static String getBaseUrl() {
        return getPropertyFromConfigFile(BASE_URL);
    }

    public static String getBrowserName() {
        return getPropertyFromConfigFile(BROWSER_NAME).toLowerCase();
    }

    public static int getWaitDurationInSeconds() {
        return Integer.parseInt(getPropertyFromConfigFile(WAIT_DURATION));
    }

    public static List<String> getBrowserOptions() {
        return JSONCustomParser.parseArrayToListByNameFromResPath(CONFIG_FILE, OPTIONS);
    }
}
