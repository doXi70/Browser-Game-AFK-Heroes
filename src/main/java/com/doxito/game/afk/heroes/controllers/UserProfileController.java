package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.dtos.EditUserProfileDto;
import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private final UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getProfile(@AuthenticationPrincipal Principal principal, Model model) {
        User user = this.userService.findByEmail(principal.getName());

        model.addAttribute("user", user);
        model.addAttribute("view", "user/profile");
        return "base-layout";
    }

    @GetMapping("/{userId}")
    public String editProfile(@AuthenticationPrincipal Principal principal,
                              @PathVariable Long userId,
                              Model model) {

        User user = this.userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("view", "user/profile-details");
        return "base-layout";
    }

    @PostMapping("{userId}")
    public String processEditProfile(@AuthenticationPrincipal Principal principal,
                                     @PathVariable Long userId,
                                     EditUserProfileDto editUserProfileDto) {

        this.userService.editUser(editUserProfileDto, principal.getName());
        return "redirect:/profile";
    }
}
