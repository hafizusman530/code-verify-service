package com.usman.service.codeverifyservice.controller;

import com.usman.service.codeverifyservice.exception.UserNotExistException;
import com.usman.service.codeverifyservice.repository.CodeVerify;
import com.usman.service.codeverifyservice.service.InMemoryCodeVerify;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.hamcrest.core.IsEqual.equalTo;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest({CodeVerifyController.class})
public class CodeVerifyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private InMemoryCodeVerify codeVerify;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @Test
    public void should_201_if_user_token_created_success() {
        when(codeVerify.generateToken(anyString())).thenReturn(anyString());
        RestAssuredMockMvc.when()
                .post("/verification-code/{userId}", "user123")
                .then()
                .statusCode(201)
                .body("resultCode", equalTo("1"))
                .body("message", equalTo("successful"));
    }

    @Test
    public void should_302_if_user_token_not_verified() {
        RestAssuredMockMvc.when()
                .get("/verification-code/{userId}/{code}", "user123", "tcv546")
                .then()
                .statusCode(404)
                .body("resultCode", equalTo("1"))
                .body("valid", equalTo("false"));
    }
}