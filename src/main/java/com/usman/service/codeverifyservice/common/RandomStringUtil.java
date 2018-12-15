package com.usman.service.codeverifyservice.common;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtil {
    public static String generateRandomCode(int length) {
        return RandomStringUtils.randomAlphanumeric(length).toUpperCase();
    }
}
