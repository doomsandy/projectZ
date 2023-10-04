package com.application.security;

import io.jsonwebtoken.Jwts;

public class JtiTokenExtractor {
    public static final String key = "nerox4ever";
    public static String extractJti(String token) {
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getId();
        } catch (Exception e) {
            return "Ошибка извлечения jti: " + e.getMessage();
        }
    }
}
