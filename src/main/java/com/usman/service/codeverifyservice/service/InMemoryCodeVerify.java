package com.usman.service.codeverifyservice.service;

import com.usman.service.codeverifyservice.common.Constants;
import com.usman.service.codeverifyservice.common.RandomStringUtil;
import com.usman.service.codeverifyservice.exception.UserAlreadyExistException;
import com.usman.service.codeverifyservice.exception.UserNotExistException;
import com.usman.service.codeverifyservice.model.User;
import com.usman.service.codeverifyservice.repository.CodeVerify;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryCodeVerify implements CodeVerify {
    private static Map<String, User> userCodeMap = new HashMap<>();
    private static List<User> userList = new ArrayList<>();

    @Override
    public void add(String userId) {
        if (!isAlreadyUserExist(userId)) {
            addUser(userId);
        }
    }

    @Override
    public boolean verify(String code, String userId) {
        if (!isAlreadyUserExist(userId)) {
            throw new UserNotExistException();
        }
        return userCodeMap.get(code)
                .getUserId()
                .equals(userId);
    }

    private void addUser(String userId) {
        String token = RandomStringUtil.
                generateRandomCode(Constants.CODE_LENGTH);
        if (userCodeMap.get(token) != null) {
            throw new UserAlreadyExistException();
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
