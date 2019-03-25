package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.dtos.ChooseHeroDto;
import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class HeroController {

    private HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping("/choose-hero")
    public String firstHeroProcess(ChooseHeroDto dto, @AuthenticationPrincipal Principal principal) {
        this.heroService.save(dto, principal.getName());
        return "redirect:/dashboard";
    }

    @GetMapping("/heroes/{heroId}")
    public String getHero(@PathVariable Long heroId, Model model) {
        Hero hero = this.heroService.findById(heroId);
        model.addAttribute("hero", hero);
        model.addAttribute("view", "heroes/hero-details");
        return "base-layout";
    }
}
