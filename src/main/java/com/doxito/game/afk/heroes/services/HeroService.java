package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.models.dtos.ChooseHeroDto;
import com.doxito.game.afk.heroes.models.dtos.HeroCreateVO;
import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.User;

import java.util.List;

public interface HeroService {

    void save(ChooseHeroDto chooseHeroDto, String email);

    Hero findById(Long id);

    List<Hero> getAllByUserId(Long userId);

    void create(HeroCreateVO createVO);
}
