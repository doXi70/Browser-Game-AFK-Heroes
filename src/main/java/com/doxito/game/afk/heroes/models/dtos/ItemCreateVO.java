package com.doxito.game.afk.heroes.models.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ItemCreateVO {

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Long damage;

    @NotNull
    private Long health;

    @NotNull
    private String slot;
}
