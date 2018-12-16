package com.usman.service.codeverifyservice.exception;

import com.usman.service.codeverifyservice.response.ApiResponse;

public class TokenNotFoundException extends RuntimeException {
    private ApiResponse apiResponse;

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public TokenNotFoundException() {
    }

    public TokenNotFoundException(String exception) {
        super(exception);
    }

    public TokenNotFoundException(ApiResponse apiResponse) {
        super("");
        this.apiResponse = apiResponse;
    }
}
