package com.doxito.game.afk.heroes.repositories;

import com.doxito.game.afk.heroes.models.entities.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdventureRepository extends JpaRepository<Adventure, Long> {

    @Query(value = "SELECT a.act_number FROM adventures AS a ORDER BY a.act_number DESC LIMIT 1", nativeQuery = true)
    Integer getLastActNumber();
}
