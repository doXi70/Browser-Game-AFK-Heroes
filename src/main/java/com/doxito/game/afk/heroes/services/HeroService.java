package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.models.dtos.ChooseHeroDto;

public interface HeroService {

    void save(ChooseHeroDto chooseHeroDto, String email);

}
