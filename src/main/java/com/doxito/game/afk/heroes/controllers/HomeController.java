package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.services.HeroService;
import com.doxito.game.afk.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;
    private final HeroService heroService;

    @Autowired
    public HomeController(UserService userService, HeroService heroService) {
        this.userService = userService;
        this.heroService = heroService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("view", "home/guest-user");
        return "base-layout";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal Principal user) {
        User loggedUser = this.userService.findByEmail(user.getName());
        List<Hero> heroes = this.heroService.getAllByUserId(loggedUser.getId());


        model.addAttribute("user", loggedUser);
        model.addAttribute("heroes", heroes);
        model.addAttribute("chooseHero", "fragments/choose-hero");
        model.addAttribute("view", "home/existing-user");
        return "base-layout";
    }
}
