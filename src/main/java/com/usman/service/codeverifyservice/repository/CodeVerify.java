package com.usman.service.codeverifyservice.repository;

public interface CodeVerify {
    String generateToken(String userId);
    boolean verify (String code, String userId);
}
