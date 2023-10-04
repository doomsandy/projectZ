package com.application.security;

import java.util.Base64;

public class Base64Decoder {
    public static String decodeBase64(String encodedString) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            return "Ошибка декодирования Base64: " + e.getMessage();
        }
    }
}