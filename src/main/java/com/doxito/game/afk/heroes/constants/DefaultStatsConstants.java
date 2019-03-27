package com.doxito.game.afk.heroes.constants;

public final class DefaultStatsConstants {

    // All Heroes
    public static final Long LEVEL = 1L;
    public static final Long EXPERIENCE = 0L;

    // Warrior
    public static final Long WARRIOR_DAMAGE = 5L;
    public static final Long WARRIOR_HEALTH = 250L;

    // Rogue
    public static final Long ROGUE_DAMAGE = 15L;
    public static final Long ROGUE_HEALTH = 180L;

    // Mage
    public static final Long MAGE_DAMAGE = 20L;
    public static final Long MAGE_HEALTH = 180L;

    // Priest
    public static final Long PRIEST_DAMAGE = 8L;
    public static final Long PRIEST_HEALTH = 150L;

    // Enemy
    public static final Integer BOSS_MULTIPLIER = 2;
    public static final Long BOSS_BASE_DAMAGE = 50L;
    public static final Long BOSS_BASE_HEALTH = 200L;

    private DefaultStatsConstants() {
    }
}
