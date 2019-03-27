package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

    private final UserService userService;

    @Autowired
    public AdministrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String adminPanel(Model model) {
        model.addAttribute("view", "admin/admin-panel");
        return "base-layout";
    }


    @GetMapping("/role-management")
    public String rolesManagement(Model model) {
        List<User> users = this.userService.findAll();

        model.addAttribute("users", users);
        model.addAttribute("view", "admin/role-management");
        return "base-layout";
    }

    @PostMapping("/roles-management")
    public String processRoleManagement() {
        return "base-layout";
    }

    @GetMapping("/active-sessions")
    public String activeSessions() {
        return "base-layout";
    }

    @GetMapping("/tavern-management")
    public String tavernManagement() {
        return "base-layout";
    }

    @GetMapping("/adventures-management")
    public String adventuresManagement() {
        return "base-layout";
    }

    @GetMapping("/dungeons-management")
    public String dungeonsManagement() {
        return "base-layout";
    }


}
