package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.Item;

import java.util.List;

public interface ItemService {

    Item findByName(String name);

    List<Item> findByHero(Hero hero);

}
