package com.usman.service.codeverifyservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private String resultCode;
    private String message;
    private String valid;

    public ApiResponse() {

    }

    public ApiResponse(String resultCode, String message, String valid) {
        this.resultCode = resultCode;
        this.message = message;
        this.valid = valid;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
