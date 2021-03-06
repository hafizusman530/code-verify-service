package com.usman.service.codeverifyservice.exception;

import com.usman.service.codeverifyservice.response.ApiResponse;

public class UserAlreadyExistException extends RuntimeException {
    private ApiResponse apiResponse;
    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
    public UserAlreadyExistException(String exception){
        super(exception);
    }
    public UserAlreadyExistException(ApiResponse apiResponse) {
        super("");
        this.apiResponse = apiResponse;
    }
}
