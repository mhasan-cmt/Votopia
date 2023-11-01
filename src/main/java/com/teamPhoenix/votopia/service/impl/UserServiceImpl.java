package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.dto.UserDto;
import com.teamPhoenix.votopia.entity.Role;
import com.teamPhoenix.votopia.entity.RoleName;
import com.teamPhoenix.votopia.entity.User;
import com.teamPhoenix.votopia.entity.VoterIdentification;
import com.teamPhoenix.votopia.exceptions.CanNotConvertImageToBase64Exception;
import com.teamPhoenix.votopia.repository.RoleRepository;
import com.teamPhoenix.votopia.repository.UserRepository;
import com.teamPhoenix.votopia.service.UserService;
import com.teamPhoenix.votopia.service.VoterIdentificationService;
import com.teamPhoenix.votopia.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final VoterIdentificationService voterIdentificationService;
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User registerUser(UserDto user) {
        return userRepository.save(mapToEntity(user));
    }

    private User mapToEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        VoterIdentification voterIdentification = voterIdentificationService.findByIdNumber(userDto.getVoterIdentification());
        user.setVoterIdentification(voterIdentification);
        if (userDto.getRole()==null){
            user.setRoles(List.of(roleRepository.findByName(RoleName.ROLE_USER)));
        }else{
            user.setRoles(List.of(roleRepository.findByName(userDto.getRole())));
        }

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        try{
            user.setProfilePicture(ImageUtil.multipartToBytearray(userDto.getProfilePicture()));
        }catch (Exception e){
            throw new CanNotConvertImageToBase64Exception();
        }
        return  user;
    }

    private UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhone(user.getPhone());
        userDto.setRole(user.getRoles().get(0).getName());
        userDto.setPassword(user.getPassword());
        userDto.setVoterIdentification(user.getVoterIdentification().getIdNumber());
        return userDto;
    }
}
