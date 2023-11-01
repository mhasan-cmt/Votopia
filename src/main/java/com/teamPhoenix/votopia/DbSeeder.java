package com.teamPhoenix.votopia;

import com.teamPhoenix.votopia.entity.Role;
import com.teamPhoenix.votopia.entity.RoleName;
import com.teamPhoenix.votopia.entity.User;
import com.teamPhoenix.votopia.service.RoleService;
import com.teamPhoenix.votopia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DbSeeder implements CommandLineRunner {
    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        generateRoles();
    }

    private void generateRoles() {
        if (roleService.count()==0){
            Role role = new Role();
            role.setName(RoleName.ROLE_USER);
            roleService.save(role);

            role = new Role();
            role.setName(RoleName.ROLE_ADMIN);
            Role admin = roleService.save(role);

            User adminUser = new User();
            adminUser.setEmail("admin@mail.com");
            adminUser.setFirstName("Admin");
            adminUser.setLastName("Admin");
            adminUser.setPhone("123456789");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            adminUser.setRoles(List.of(admin));
            userService.save(adminUser);
        }
    }
}
