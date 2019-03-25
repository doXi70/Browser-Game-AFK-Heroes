package com.doxito.game.afk.heroes.models.entities;


import com.doxito.game.afk.heroes.constants.HeroClass;
import com.doxito.game.afk.heroes.constants.HeroesInitialStats;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Long level;

    @Column(name = "experience")
    private Long experience;

    @Enumerated(EnumType.STRING)
    @Column(name = "hero_class")
    private HeroClass heroClass;

    @Column(name = "damage")
    private Long damage;

    @Column(name = "health")
    private Long health;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToMany(mappedBy = "heroes")
    private List<Item> items;

    public Hero() {
        this.items = new ArrayList<>();
        this.experience = HeroesInitialStats.EXPERIENCE;
        this.level = HeroesInitialStats.LEVEL;
    }

}
