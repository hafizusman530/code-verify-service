package com.usman.service.codeverifyservice.repository;

public interface CodeVerify {
    void add(String userId);
    boolean verify (String code, String userId);
}
