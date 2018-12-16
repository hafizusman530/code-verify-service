package com.usman.service.codeverifyservice.exception;

import com.usman.service.codeverifyservice.response.ApiResponse;

public class UserNotExistException extends RuntimeException {
    private ApiResponse apiResponse;

    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public UserNotExistException(String exception) {
        super(exception);
    }

    public UserNotExistException(ApiResponse apiResponse) {
        super("");
        this.apiResponse = apiResponse;
    }
}
