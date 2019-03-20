package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.models.entities.Role;

public interface RoleService {

    Role findByName(String name);
}
