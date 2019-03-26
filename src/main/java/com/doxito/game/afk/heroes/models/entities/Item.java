package com.doxito.game.afk.heroes.models.entities;

import com.doxito.game.afk.heroes.constants.ItemSlot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "slot", nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemSlot slot;

    @Column(name = "damage")
    private Long damage;

    @Column(name = "health")
    private Long health;

    @ManyToMany(mappedBy = "items",fetch = FetchType.EAGER)
    private List<Hero> heroes;

    public Item() {
        this.heroes = new ArrayList<>();
    }
}
