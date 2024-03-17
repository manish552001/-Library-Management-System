package com.manish.lms.service;

import com.manish.lms.model.User;

public interface UserService {
    User findByUsername(String username);
}
