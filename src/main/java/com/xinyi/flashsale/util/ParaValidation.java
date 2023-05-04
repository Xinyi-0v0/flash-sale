package com.xinyi.flashsale.util;

public class ParaValidation {

    public static boolean isValidString(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean isValidLong(Long num) {
        return num != null && num >= 0;
    }
}
