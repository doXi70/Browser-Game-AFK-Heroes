package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.constants.GameDifficulty;
import com.doxito.game.afk.heroes.models.dtos.AdventureCreateDto;
import com.doxito.game.afk.heroes.models.entities.Adventure;
import com.doxito.game.afk.heroes.repositories.AdventureRepository;
import com.doxito.game.afk.heroes.services.AdventureService;
import com.doxito.game.afk.heroes.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventureServiceImpl implements AdventureService {

    private AdventureRepository adventureRepository;
    private Mapper mapper;

    @Autowired
    public AdventureServiceImpl(AdventureRepository adventureRepository, Mapper mapper) {
        this.adventureRepository = adventureRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(AdventureCreateDto adventureCreateDto) {
        Adventure adventure = new Adventure();
        this.mapper.map(adventureCreateDto, adventure);

        GameDifficulty gameDifficulty = GameDifficulty.findByName(adventureCreateDto.getDifficulty());
        adventure.setDifficulty(gameDifficulty);

        Integer lastActNumber = this.adventureRepository.getLastActNumber();
        if (lastActNumber == null) {
            lastActNumber = 1;
        }

        adventure.setActNumber(++lastActNumber);
        this.adventureRepository.save(adventure);
    }
}
