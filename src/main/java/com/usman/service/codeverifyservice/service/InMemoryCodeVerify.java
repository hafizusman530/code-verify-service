package com.usman.service.codeverifyservice.service;

import com.usman.service.codeverifyservice.common.Constants;
import com.usman.service.codeverifyservice.common.RandomStringUtil;
import com.usman.service.codeverifyservice.exception.TokenNotFoundException;
import com.usman.service.codeverifyservice.exception.UserAlreadyExistException;
import com.usman.service.codeverifyservice.exception.UserNotExistException;
import com.usman.service.codeverifyservice.model.User;
import com.usman.service.codeverifyservice.repository.CodeVerify;
import com.usman.service.codeverifyservice.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryCodeVerify implements CodeVerify {
    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryCodeVerify.class);
    private static Map<String, User> userCodeMap = new HashMap<>();
    private static List<User> userList = new ArrayList<>();

    @Override
    public void add(String userId) {
        if (isAlreadyUserExist(userId)) {
            throw new UserAlreadyExistException(new ApiResponse("0", "error", null));
        }
        addUser(userId);

    }

    @Override
    public boolean verify(String userId, String code) {
        if (!isAlreadyUserExist(userId)) {
            throw new UserNotExistException(new ApiResponse("0", "error", null));
        }
        Optional<User> user = Optional.ofNullable(userCodeMap.get(code));
        return user.orElseThrow(() -> new TokenNotFoundException(new ApiResponse("0", null, "false")))
                .getUserId().equals(userId);
    }

    private void addUser(String userId) {
        String token = RandomStringUtil.
                generateRandomCode(Constants.CODE_LENGTH);
        LOGGER.info("token " + token);
        if (userCodeMap.get(token) != null) {
            throw new UserAlreadyExistException(new ApiResponse("0", "error", null));
        }
        User user = new User(userId, token);
        userList.add(user);
        userCodeMap.put(token, user);
    }

    private boolean isAlreadyUserExist(String userId) {
        return userList.stream()
                .anyMatch(user -> user.getUserId().equals(userId));
    }
}
