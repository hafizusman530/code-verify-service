package com.usman.service.codeverifyservice.controller;

import com.usman.service.codeverifyservice.model.User;
import com.usman.service.codeverifyservice.repository.CodeVerify;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.core.IsEqual.equalTo;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@WebMvcTest({CodeVerifyController.class})
class CodeVerifyControllerTest {
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("123", "abc123"));
        userList.add(new User("1234", "abc1234"));
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CodeVerify codeVerify;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @Test
    public void should_404_if_code_not_verify() {

    }

    @Test
    public void should_400_if_user_token_already_created() {

    }

    @Test
    public void should_201_if_user_token_created_success() {
        RestAssuredMockMvc.when()
                .get("/verification-code/{userId}", "user123")
                .then()
                .statusCode(201)
                .body("resultCode", equalTo("1"))
                .body("message", equalTo("sucessfull"));
    }

    @Test
    public void should_302_if_user_token_verified() {
        when(codeVerify.verify(eq(anyString()), eq(anyString()))).thenReturn(true);
        when(codeVerify.verify(eq(null), eq(null))).thenReturn(false);
        when(codeVerify.verify(eq(""), eq(""))).thenReturn(false);
    }
}