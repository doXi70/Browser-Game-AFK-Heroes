package com.doxito.game.afk.heroes.configs;

import com.doxito.game.afk.heroes.constants.UserRole;
import com.doxito.game.afk.heroes.models.entities.Role;
import com.doxito.game.afk.heroes.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInserts {

    private final RoleService roleService;

    @Autowired
    public DatabaseInserts(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDb() {
        insertRoles();
    }

    private void insertRoles() {
        Role userRole = this.roleService.findByName(UserRole.USER);

        if (userRole == null) {
            this.roleService.createNewRole(new Role(UserRole.USER));
        }
    }
}
