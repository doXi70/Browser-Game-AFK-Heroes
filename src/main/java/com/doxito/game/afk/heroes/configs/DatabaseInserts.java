package com.doxito.game.afk.heroes.configs;

import com.doxito.game.afk.heroes.constants.UserRole;
import com.doxito.game.afk.heroes.models.entities.Role;
import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.services.ItemService;
import com.doxito.game.afk.heroes.services.RoleService;
import com.doxito.game.afk.heroes.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Slf4j
@Component
public class DatabaseInserts {

    private final RoleService roleService;
    private final ItemService itemsService;
    private final UserService userService;

    @Autowired
    public DatabaseInserts(RoleService roleService, ItemService itemsService, UserService userService) {
        this.roleService = roleService;
        this.itemsService = itemsService;
        this.userService = userService;
    }

    @PostConstruct
    public void initDb() {
        log.info("Initial DB inserts started!");

        insertRoles();
//        createAdminAccount();

        log.info("Initial DB inserts DONE!");
    }

    private void insertRoles() {
        Role userRole = this.roleService.findByName(UserRole.USER);

        if (userRole == null) {
            log.info("Inserting roles ...");
            this.roleService.createNewRole(new Role(UserRole.USER));
            this.roleService.createNewRole(new Role(UserRole.ADMIN));
        }
    }

    private void createAdminAccount() {
        User found = this.userService.findByEmail("miro.vd1@abv.bg");
        if (Objects.isNull(found)) {
            log.info("Creating admin account ...");

            User user = new User();
            user.setEmail("miro.vd1@abv.bg");
            user.setUsername("doXi70");
            user.setPassword(new BCryptPasswordEncoder().encode("1234"));
            user.setFirstName("Miroslav");
            user.setLastName("Petkov");
            user.addRole(this.roleService.findByName(UserRole.ADMIN));
            this.userService.save(user);
        }
    }
}
