package com.doxito.game.afk.heroes.controllers;

import com.doxito.game.afk.heroes.models.dtos.HeroCreateVO;
import com.doxito.game.afk.heroes.models.dtos.ItemCreateVO;
import com.doxito.game.afk.heroes.services.HeroService;
import com.doxito.game.afk.heroes.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tavern")
public class TavernController {

    private final ItemService itemService;
    private final HeroService heroService;

    @Autowired
    public TavernController(ItemService itemService, HeroService heroService) {
        this.itemService = itemService;
        this.heroService = heroService;
    }

    //TODO: restrict to admin only
    @GetMapping("/heroes")
    public String hero(Model model) {
        model.addAttribute("view", "tavern/setup-hero-add");
        return "base-layout";
    }

    //TODO: restrict to admin only
    @PostMapping("/heroes")
    public String processHero(HeroCreateVO createVO) {
        this.heroService.create(createVO);
        return "redirect:/admin/tavern-management";
    }

    //TODO: restrict to admin only
    @GetMapping("/items")
    public String item(Model model) {
        model.addAttribute("view", "tavern/setup-item-add");
        return "base-layout";
    }

    //TODO: restrict to admin only
    @PostMapping("/items")
    public String processItem(ItemCreateVO createVO) {
        this.itemService.create(createVO);
        return "redirect:/admin/tavern-management";
    }
}
