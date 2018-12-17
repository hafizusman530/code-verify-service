package com.usman.service.codeverifyservice.controller;

import com.usman.service.codeverifyservice.repository.CodeVerify;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({CodeVerifyController.class})
class CodeVerifyControllerTest {
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

    }

    @Test
    public void should_302_if_user_token_verified() {

    }
}