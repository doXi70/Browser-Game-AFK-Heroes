package com.doxito.game.afk.heroes.repositories;

import com.doxito.game.afk.heroes.models.entities.Dungeon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DungeonRepository extends JpaRepository<Dungeon, Long> {

    @Query(value = "SELECT d.level_number FROM dungeons AS d WHERE d.adventure_id=?1 " +
            "ORDER BY a.level_number DESC LIMIT 1", nativeQuery = true)
    Integer getLastLevelFromAdventure(Long adventureId);

}
