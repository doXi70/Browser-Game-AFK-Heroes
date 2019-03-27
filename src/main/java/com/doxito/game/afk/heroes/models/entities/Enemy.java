package com.doxito.game.afk.heroes.models.entities;

import com.doxito.game.afk.heroes.constants.DefaultStatsConstants;
import com.doxito.game.afk.heroes.constants.EnemyType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "enemies")
public class Enemy extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Item> dropItems;

    @Column(name = "base_damage")
    private Long baseDamage;

    @Column(name = "base_health")
    private Long baseHealth;

    @ManyToOne
    private Dungeon dungeon;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EnemyType type;

    @Column(name = "experience_reward")
    private Long experienceReward;

    @Transactional
    public Long getDamage() {
        return Math.round(this.dungeon.getAdventure().getDifficulty().getMultiplayer() * baseDamage);
    }

    @Transactional
    public Long getExperienceReward() {
        return type.equals(EnemyType.BOSS) ?
                Math.round(experienceReward * DefaultStatsConstants.BOSS_MULTIPLIER) : experienceReward;
    }
}
