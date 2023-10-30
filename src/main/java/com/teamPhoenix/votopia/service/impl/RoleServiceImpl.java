package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.Role;
import com.teamPhoenix.votopia.repository.RoleRepository;
import com.teamPhoenix.votopia.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public long count() {
        return roleRepository.count();
    }
}
