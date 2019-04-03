package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.services.AdventureService;
import com.doxito.game.afk.heroes.services.Mapper;
import com.doxito.game.afk.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

    private final UserService userService;
    private final AdventureService adventureService;
    private final Mapper mapper;

    @Autowired
    public AdministrationController(UserService userService, AdventureService adventureService, Mapper mapper) {
        this.userService = userService;
        this.adventureService = adventureService;
        this.mapper = mapper;
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

    @PostMapping("/role-management/{userId}")
    public String processRoleManagement(@PathVariable Long userId) {
        this.userService.changeRole(userId);
        return "redirect:/admin";
    }

    @GetMapping("/active-sessions")
    public String activeSessions(Model model) {
        model.addAttribute("users",  this.userService.getAllActiveSessions());
        model.addAttribute("view", "admin/active-sessions");
        return "base-layout";
    }

    @GetMapping("/tavern-management")
    public String tavernManagement(Model model) {
        model.addAttribute("view", "tavern/setup");
        return "base-layout";
    }

    @GetMapping("/adventures-management")
    public String adventure(Model model) {
        model.addAttribute("view", "admin/adventures-management");
        return "base-layout";
    }


    @GetMapping("/dungeons-management")
    public String dungeonsManagement(Model model) {
        model.addAttribute("adventures", this.adventureService.findAll());
        model.addAttribute("view", "admin/dungeons-management");
        return "base-layout";
    }


}
