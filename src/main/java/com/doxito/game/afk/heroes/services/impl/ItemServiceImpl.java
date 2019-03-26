package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.Item;
import com.doxito.game.afk.heroes.repositories.ItemRepository;
import com.doxito.game.afk.heroes.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item findByName(String name) {
        return this.itemRepository.findByName(name);
    }

    @Override
    public List<Item> findByHero(Hero hero) {
        return this.itemRepository.findAllByHeroesIs(hero);
    }


}
