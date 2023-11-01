package com.teamPhoenix.votopia.dto;

import com.teamPhoenix.votopia.entity.Role;
import com.teamPhoenix.votopia.entity.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Please enter your Email")
    @Email
    private String email;
    @NotEmpty(message = "Please enter your Password")
    private String password;
    @NotEmpty(message = "Please enter your Phone Number")
    private String phone;
    private RoleName role;
    private String voterIdentification;
    private String confirmPassword;
    private MultipartFile profilePicture;
}
