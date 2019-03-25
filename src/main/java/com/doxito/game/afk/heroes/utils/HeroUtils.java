package com.doxito.game.afk.heroes.utils;

import com.doxito.game.afk.heroes.constants.HeroClass;
import com.doxito.game.afk.heroes.constants.HeroesInitialStats;
import com.doxito.game.afk.heroes.models.entities.Hero;

import java.util.Random;

public class HeroUtils {

    public static void setInitialValuesByClass(String heroClass, Hero hero) {
        hero.setName(generateHeroName(heroClass));

        switch (heroClass) {
            case "warrior":
                hero.setHeroClass(HeroClass.WARRIOR);
                hero.setDamage(HeroesInitialStats.WARRIOR_DAMAGE);
                hero.setHealth(HeroesInitialStats.WARRIOR_HEALTH);
                break;
            case "mage":
                hero.setHeroClass(HeroClass.MAGE);
                hero.setDamage(HeroesInitialStats.MAGE_DAMAGE);
                hero.setHealth(HeroesInitialStats.MAGE_HEALTH);
                break;
            case "rogue":
                hero.setHeroClass(HeroClass.ROGUE);
                hero.setDamage(HeroesInitialStats.ROGUE_DAMAGE);
                hero.setHealth(HeroesInitialStats.ROGUE_HEALTH);
                break;
            case "priest":
                hero.setHeroClass(HeroClass.PRIEST);
                hero.setDamage(HeroesInitialStats.PRIEST_DAMAGE);
                hero.setHealth(HeroesInitialStats.PRIEST_HEALTH);
                break;
            default:
                throw new IllegalArgumentException("No such hero class!");
        }
    }

    public static String generateHeroName(String heroClass) {
        return heroClass + "_" + new Random().nextInt();
    }
}
