package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.models.dtos.ChooseHeroDto;
import com.doxito.game.afk.heroes.models.dtos.HeroCreateVO;
import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.repositories.HeroRepository;
import com.doxito.game.afk.heroes.services.HeroService;
import com.doxito.game.afk.heroes.services.ItemService;
import com.doxito.game.afk.heroes.services.Mapper;
import com.doxito.game.afk.heroes.services.UserService;
import com.doxito.game.afk.heroes.utils.HeroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private HeroRepository heroRepository;
    private UserService userService;
    private ItemService itemService;
    private Mapper mapper;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository, UserService userService, ItemService itemService, Mapper mapper) {
        this.heroRepository = heroRepository;
        this.userService = userService;
        this.itemService = itemService;
        this.mapper = mapper;
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
        return this.heroRepository.findById(id);
    }

    @Override
    public List<Hero> getAllByUserId(Long userId) {
        return this.heroRepository.findAllByUserId(userId);
    }

    @Override
    public void create(HeroCreateVO createVO) {
        Hero hero = new Hero();
        this.mapper.map(createVO, hero);
        this.heroRepository.save(hero);
    }

}
