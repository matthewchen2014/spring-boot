package com.spring.controller;

import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    User get(@PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @PostMapping("/{userId}/copy")
    void copy(@PathVariable Integer userId) {
        userService.copy(userId);
    }

    @PostMapping
    User create() {
        return userService.create();
    }
}
