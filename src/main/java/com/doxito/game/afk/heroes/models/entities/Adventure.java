package com.doxito.game.afk.heroes.models.entities;

import com.doxito.game.afk.heroes.constants.GameDifficulty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "adventures")
public class Adventure extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private GameDifficulty difficulty;

    @Column(name = "act_number")
    private Integer actNumber;
}
