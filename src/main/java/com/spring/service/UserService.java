package com.spring.service;

import com.spring.model.User;

import java.util.List;

public interface UserService {
    User getById(Integer id);

    void create(User user);

    void copy(Integer userId);

    User create();
}
