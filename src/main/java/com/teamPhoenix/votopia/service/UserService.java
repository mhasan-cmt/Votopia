package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.dto.UserDto;
import com.teamPhoenix.votopia.entity.User;

public interface UserService {
    User findByEmail(String email);
    User registerUser(UserDto user);
}
