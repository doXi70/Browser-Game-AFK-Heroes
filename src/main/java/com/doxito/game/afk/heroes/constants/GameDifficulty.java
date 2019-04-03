package com.doxito.game.afk.heroes.constants;

import lombok.Getter;

@Getter
public enum GameDifficulty {
    EASY(1.0),
    MEDIUM(1.5),
    HARD(2.0),
    HELL(2.5);

    private Double multiplayer;

    GameDifficulty(Double multiplayer) {
        this.multiplayer = multiplayer;
    }

    public static GameDifficulty findByName(String name) {
        for (GameDifficulty gameDifficulty : GameDifficulty.values()) {
            if (gameDifficulty.name().equalsIgnoreCase(name)) {
                return gameDifficulty;
            }
        }

        throw new IllegalArgumentException("Dungeon with name " + name + " does not exist!");
    }
}
