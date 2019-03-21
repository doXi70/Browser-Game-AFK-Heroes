package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.dtos.ChooseHeroDto;
import com.doxito.game.afk.heroes.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HeroesController {

    private HeroService heroService;

    @Autowired
    public HeroesController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping("/choose-hero")
    public String firstHeroProcess(ChooseHeroDto dto, @AuthenticationPrincipal Principal principal) {
        this.heroService.save(dto, principal.getName());
        return "redirect:/dashboard";
    }
}
