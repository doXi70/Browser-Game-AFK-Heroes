package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.models.dtos.DungeonCreateDto;
import com.doxito.game.afk.heroes.models.entities.Adventure;
import com.doxito.game.afk.heroes.models.entities.Dungeon;
import com.doxito.game.afk.heroes.repositories.AdventureRepository;
import com.doxito.game.afk.heroes.repositories.DungeonRepository;
import com.doxito.game.afk.heroes.services.DungeonService;
import com.doxito.game.afk.heroes.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DungeonServiceImpl implements DungeonService {

    private AdventureRepository adventureRepository;
    private DungeonRepository dungeonRepository;
    private Mapper mapper;

    @Autowired
    public DungeonServiceImpl(AdventureRepository adventureRepository, DungeonRepository dungeonRepository, Mapper mapper) {
        this.adventureRepository = adventureRepository;
        this.dungeonRepository = dungeonRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(DungeonCreateDto dungeonCreateDto) {
        Dungeon dungeon = new Dungeon();
        mapper.map(dungeonCreateDto, dungeon);
        this.dungeonRepository.save(dungeon);
    }
}
