package com.usman.service.codeverifyservice.controller;

import com.usman.service.codeverifyservice.repository.CodeVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/verification-code")
public class CodeVerifyController {

    private final CodeVerify codeVerify;

    @Autowired
    public CodeVerifyController(CodeVerify codeVerify) {
        this.codeVerify = codeVerify;
    }

    @RequestMapping(path = "/{user_id}", method = RequestMethod.POST, consumes = "application/json")
    public String code(@PathVariable String userId) {
        return "";
    }

    @RequestMapping(path = "/{user_id}/{code}", method = RequestMethod.POST, consumes = "application/json")
    public String verify(@PathVariable String userId, @PathVariable String code) {
        return "";
    }
}
