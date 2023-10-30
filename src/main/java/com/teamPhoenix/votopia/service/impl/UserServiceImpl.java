package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.User;
import com.teamPhoenix.votopia.repository.UserRepository;
import com.teamPhoenix.votopia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User RegisterUser(User user) {
        return userRepository.save(user);
    }
}
