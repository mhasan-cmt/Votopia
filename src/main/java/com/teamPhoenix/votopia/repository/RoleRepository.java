package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.Role;
import com.teamPhoenix.votopia.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName role);
}
