package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.models.dtos.ChooseHeroDto;
import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.repositories.HeroRepository;
import com.doxito.game.afk.heroes.services.HeroService;
import com.doxito.game.afk.heroes.services.UserService;
import com.doxito.game.afk.heroes.utils.HeroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private HeroRepository heroRepository;
    private UserService userService;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository, UserService userService) {
        this.heroRepository = heroRepository;
        this.userService = userService;
    }


    @Override
    public void save(ChooseHeroDto heroDto, String email) {
        String heroClass = heroDto.getHero();

        Hero hero = new Hero();
        HeroUtils.setInitialValuesByClass(heroClass, hero);
        hero.setUser(this.userService.findByEmail(email));

        this.heroRepository.save(hero);
    }

    @Override
    public Hero findById(Long id) {
        return this.heroRepository.findOne(id);
    }

    @Override
    public List<Hero> getAllByUserId(Long userId) {
        return this.heroRepository.findAllByUserId(userId);
    }

}
