package com.doxito.game.afk.heroes.models.entities;

import com.doxito.game.afk.heroes.constants.GameDifficulty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "dungeons")
public class Dungeon extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Adventure adventure;

    @Column(name = "level_number")
    private Integer levelNumber;

    @Transactional
    public Long getExperienceReward() {
        Objects.requireNonNull(adventure, "Adventure for this dungeon is null!");
        GameDifficulty adventureDifficulty = adventure.getDifficulty();

        for (GameDifficulty gameDifficulty : GameDifficulty.values()) {
            if (adventureDifficulty.equals(gameDifficulty)) {
                return Math.round(gameDifficulty.getExpMultiplayer() * adventure.getActNumber());
            }
        }

        throw new IllegalArgumentException("Adventure difficulty -> " + adventureDifficulty + " does not exist!" );
    }
}
