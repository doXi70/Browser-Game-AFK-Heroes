package com.doxito.game.afk.heroes.models.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class HeroCreateVO {

    @NotNull
    private String name;

    @NotNull
    private String heroClass;

    @NotNull
    private Double price;

    @NotNull
    private Long damage;

    @NotNull
    private Long health;
}
