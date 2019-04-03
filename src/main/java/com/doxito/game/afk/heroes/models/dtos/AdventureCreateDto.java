package com.doxito.game.afk.heroes.models.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AdventureCreateDto {

    @NotNull
    private String name;

    @NotNull
    private String difficulty;

}
