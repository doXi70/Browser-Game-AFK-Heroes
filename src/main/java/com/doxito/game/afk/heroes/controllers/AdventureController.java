package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.dtos.AdventureCreateDto;
import com.doxito.game.afk.heroes.services.AdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adventures")
public class AdventureController {

    private final AdventureService adventureService;

    @Autowired
    public AdventureController(AdventureService adventureService) {
        this.adventureService = adventureService;
    }

    @PostMapping
    public String processAdventure(AdventureCreateDto dto) {
        this.adventureService.save(dto);
        return "redirect:/admin";
    }
}
