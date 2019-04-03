package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.dtos.DungeonCreateDto;
import com.doxito.game.afk.heroes.services.DungeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dungeons")
public class DungeonController {

    private DungeonService dungeonService;

    @Autowired
    public DungeonController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @PostMapping
    public String processDungeon(DungeonCreateDto dungeonCreateDto) {
        this.dungeonService.save(dungeonCreateDto);
        return "redirect:/admin";
    }

}
