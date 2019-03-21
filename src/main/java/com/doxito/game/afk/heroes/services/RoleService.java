package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.constants.UserRole;
import com.doxito.game.afk.heroes.models.entities.Role;

public interface RoleService {

    Role findByName(UserRole userRole);

    void createNewRole(Role role);
}
