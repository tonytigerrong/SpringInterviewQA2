package com.spring.interview.services;

import com.spring.interview.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
