package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.constants.ItemSlot;
import com.doxito.game.afk.heroes.models.dtos.ItemCreateVO;
import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.Item;
import com.doxito.game.afk.heroes.repositories.ItemRepository;
import com.doxito.game.afk.heroes.services.ItemService;
import com.doxito.game.afk.heroes.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private Mapper mapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, Mapper mapper) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
    }

    @Override
    public Item findByName(String name) {
        return this.itemRepository.findByName(name);
    }

    @Override
    public List<Item> findByHero(Hero hero) {
        return this.itemRepository.findAllByHeroesIs(hero);
    }

    @Override
    public void create(ItemCreateVO createVO) {
        Item item = new Item();
        mapper.map(createVO, item);

        ItemSlot slot = ItemSlot.findByName(createVO.getSlot());
        item.setSlot(slot);

        this.itemRepository.save(item);
    }


}
