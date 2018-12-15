package com.usman.service.codeverifyservice.controller;

import com.usman.service.codeverifyservice.model.User;
import com.usman.service.codeverifyservice.repository.CodeVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/verification-code")
public class CodeVerifyController {

    private final CodeVerify codeVerify;

    @Autowired
    public CodeVerifyController(CodeVerify codeVerify) {
        this.codeVerify = codeVerify;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody User user) {
        codeVerify.add(user.getUserId());
        return new ResponseEntity<>("successful", HttpStatus.OK);
    }

    @RequestMapping(path = "/{userId}/{code}", method = RequestMethod.GET)
    public ResponseEntity<String> verify(@PathVariable("userId") String userId, @PathVariable("code") String code) {
        boolean isCodeVerified = codeVerify.verify(userId, code);
        return new ResponseEntity<>(isCodeVerified ? "true" : "false", HttpStatus.OK);
    }
}
