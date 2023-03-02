package com.idftech.testtask.testutils;

import com.idftech.testtask.utils.logger.CustomLogger;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@UtilityClass
public class UserCredentialsUtil {
    private static final int MIN_STRING_LENGTH = 3;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_USER_NAME_LENGTH = 10;
    private static final String RUS_CHARACTERS = "aбвгдеёжзийклмнопрстуфхчщъыьэюя";
    private static final String ENG_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String ENG_CAPITAL_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERALS = "1234567890";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";
    private static final String EMPTY = "";
    private static final String REPLACEMENT_REGEX = "[%s]";
    private static final Random RANDOM = new Random();

    private static String getRandomString(int maxLength) {
        return RandomStringUtils.random(RANDOM.nextInt(maxLength) + MIN_STRING_LENGTH,
                true, true);
    }

    private static String getPasswordObligatoryPart() {
        StringBuilder result = new StringBuilder();
        result.append(RUS_CHARACTERS.charAt(RANDOM.nextInt(RUS_CHARACTERS.length())))
                .append(ENG_CHARACTERS.charAt(RANDOM.nextInt(ENG_CHARACTERS.length())))
                .append(ENG_CAPITAL_CHARACTERS.charAt(RANDOM.nextInt(ENG_CAPITAL_CHARACTERS.length())))
                .append(NUMERALS.charAt(RANDOM.nextInt(NUMERALS.length())))
                .append(SPECIAL_CHARACTERS.charAt(RANDOM.nextInt(SPECIAL_CHARACTERS.length())));
        return result.toString();
    }

    public static String getRandomUserName() {
        String randomUserName = getRandomString(MAX_USER_NAME_LENGTH);
        CustomLogger.info(String.format("UserCredentialsUtil.getRandomUserName() : %s", randomUserName));
        return randomUserName;
    }

    public static String getValidRandomPassword() {
        StringBuilder result = new StringBuilder();
        result.append(getRandomString(MIN_PASSWORD_LENGTH))
                .append(getPasswordObligatoryPart());
        if(result.toString().length() < MIN_PASSWORD_LENGTH) {
            while (result.toString().length() < MIN_PASSWORD_LENGTH) {
                result.append(getPasswordObligatoryPart());
            }
        }
        CustomLogger.info(String.format("UserCredentialsUtil.getRandomPassword() : %s", result));
        return result.toString();
    }

    public static String getEmptyCredential() {
        return EMPTY;
    }

    public static String getShortPassword() {
        return getPasswordObligatoryPart();
    }

    public static String getDigitMissingPassword() {
        return getValidRandomPassword().replaceAll(String.format(REPLACEMENT_REGEX, NUMERALS), EMPTY);
    }

    public static String getSpecialCharacterMissingPassword() {
        return getValidRandomPassword().replaceAll(String.format(REPLACEMENT_REGEX, SPECIAL_CHARACTERS), EMPTY);
    }
}
