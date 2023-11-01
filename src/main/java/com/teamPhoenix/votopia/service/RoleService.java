package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.Role;
import com.teamPhoenix.votopia.entity.RoleName;

public interface RoleService {
    Role save(Role role);
    long count();

    Role findByName(RoleName roleName);
}
