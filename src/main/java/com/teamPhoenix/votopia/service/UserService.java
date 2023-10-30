package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.User;

public interface UserService {
    User findByEmail(String email);
    User RegisterUser(User user);
}
