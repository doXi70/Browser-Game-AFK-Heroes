package com.doxito.game.afk.heroes.models.dtos;

import com.doxito.game.afk.heroes.models.entities.Adventure;
import com.doxito.game.afk.heroes.models.entities.Enemy;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class DungeonCreateDto {

    @NotNull
    private String name;

    private String adventure;

    private List<Enemy> enemies;

}
