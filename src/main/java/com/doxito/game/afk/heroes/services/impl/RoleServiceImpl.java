package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.constants.UserRole;
import com.doxito.game.afk.heroes.models.entities.Role;
import com.doxito.game.afk.heroes.repositories.RoleRepository;
import com.doxito.game.afk.heroes.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(UserRole userRole) {
        return this.roleRepository.findByName(userRole.getName());
    }

    @Override
    public void createNewRole(Role role) {
        this.roleRepository.save(role);
    }
}
