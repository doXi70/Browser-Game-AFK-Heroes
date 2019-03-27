package com.doxito.game.afk.heroes.utils;

import com.doxito.game.afk.heroes.constants.HeroClass;
import com.doxito.game.afk.heroes.constants.DefaultStatsConstants;
import com.doxito.game.afk.heroes.constants.ItemSlot;
import com.doxito.game.afk.heroes.models.entities.Hero;
import com.doxito.game.afk.heroes.models.entities.Item;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class HeroUtils {

    public static void setInitialValuesByClass(String heroClass, Hero hero) {
        hero.setName(generateHeroName(heroClass));

        switch (heroClass) {
            case "warrior":
                hero.setHeroClass(HeroClass.WARRIOR);
                hero.setDamage(DefaultStatsConstants.WARRIOR_DAMAGE);
                hero.setHealth(DefaultStatsConstants.WARRIOR_HEALTH);
                break;
            case "mage":
                hero.setHeroClass(HeroClass.MAGE);
                hero.setDamage(DefaultStatsConstants.MAGE_DAMAGE);
                hero.setHealth(DefaultStatsConstants.MAGE_HEALTH);
                break;
            case "rogue":
                hero.setHeroClass(HeroClass.ROGUE);
                hero.setDamage(DefaultStatsConstants.ROGUE_DAMAGE);
                hero.setHealth(DefaultStatsConstants.ROGUE_HEALTH);
                break;
            case "priest":
                hero.setHeroClass(HeroClass.PRIEST);
                hero.setDamage(DefaultStatsConstants.PRIEST_DAMAGE);
                hero.setHealth(DefaultStatsConstants.PRIEST_HEALTH);
                break;
            default:
                throw new IllegalArgumentException("No such hero class!");
        }
    }

    public static String generateHeroName(String heroClass) {
        return heroClass + "_" + new Random().nextInt();
    }

    public static boolean isContainingItemSlot(Collection<Item> items, ItemSlot slot) {
        for (Item item : items) {
            if (item.getSlot().equals(slot)) {
                return true;
            }
        }

        return false;
    }

    public static Item getItemBySlot(Collection<Item> items, ItemSlot slot) {
        for (Item item : items) {
            if (item.getSlot().equals(slot)) {
                return item;
            }
        }

        return null;
    }

    public static Map<ItemSlot, Item> getAllItemsMap(Collection<Item> items) {
        return items.stream().collect(Collectors.toMap(Item::getSlot, item -> item));
    }

}
