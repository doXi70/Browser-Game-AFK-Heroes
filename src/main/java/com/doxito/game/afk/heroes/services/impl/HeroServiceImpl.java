package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.constants.HeroClass;
import com.doxito.game.afk.heroes.models.dtos.ChooseHeroDto;
import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.repositories.HeroRepository;
import com.doxito.game.afk.heroes.services.HeroService;
import com.doxito.game.afk.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

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

        hero.setName(heroClass + "_" + new Random().nextInt(1000000));
        hero.setHeroClass(setHeroClass(heroClass));
        hero.setDamage(200L);
        hero.setHealth(200L);
        this.heroRepository.save(hero);


        User user = this.userService.findByEmail(email);
        user.getHeroes().add(hero);
        this.userService.save(user);
    }

    private HeroClass setHeroClass(String heroClass) {
        switch (heroClass) {
            case "warrior":
                return HeroClass.WARRIOR;
            case "mage":
                return HeroClass.MAGE;
            case "rogue":
                return HeroClass.ROGUE;
            case "priest":
                return HeroClass.PRIEST;
            default:
                throw new IllegalArgumentException("No such hero type!");
        }
    }
}
