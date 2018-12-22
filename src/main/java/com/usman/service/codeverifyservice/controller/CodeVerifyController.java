package com.usman.service.codeverifyservice.controller;

import com.usman.service.codeverifyservice.repository.CodeVerify;
import com.usman.service.codeverifyservice.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/verification-code")
public class CodeVerifyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeVerifyController.class);

    private final CodeVerify codeVerify;

    @Autowired
    public CodeVerifyController(CodeVerify codeVerify) {
        this.codeVerify = codeVerify;
    }

    @PostMapping(path = "/{userId}")
    public ResponseEntity<Object> add(@PathVariable("userId") String userId) {
        String token = codeVerify.generateToken(userId);
        LOGGER.info("token " + token);
        return new ResponseEntity<>(new ApiResponse("1", "successful", null), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{userId}/{code}", method = RequestMethod.GET)
    public ResponseEntity<Object> verify(@PathVariable("userId") String userId, @PathVariable("code") String code) {
        boolean isVerify = codeVerify.verify(userId, code);
        HttpStatus httpStatus;
        if (!isVerify) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            httpStatus = HttpStatus.FOUND;
        }
        return new ResponseEntity<>(new ApiResponse("1", null, String.valueOf(isVerify)), httpStatus);
    }
}
