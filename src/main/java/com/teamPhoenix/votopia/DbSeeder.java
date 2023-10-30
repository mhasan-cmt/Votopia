package com.teamPhoenix.votopia;

import com.teamPhoenix.votopia.entity.Role;
import com.teamPhoenix.votopia.entity.RoleName;
import com.teamPhoenix.votopia.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DbSeeder implements CommandLineRunner {
    private final RoleService roleService;
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
            roleService.save(role);
        }
    }
}
