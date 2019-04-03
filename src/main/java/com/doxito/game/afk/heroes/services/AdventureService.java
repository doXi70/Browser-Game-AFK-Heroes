package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.models.dtos.AdventureCreateDto;
import com.doxito.game.afk.heroes.models.entities.Adventure;

import java.util.List;

public interface AdventureService {

    void save(AdventureCreateDto adventureCreateDto);

    List<Adventure> findAll();
}
