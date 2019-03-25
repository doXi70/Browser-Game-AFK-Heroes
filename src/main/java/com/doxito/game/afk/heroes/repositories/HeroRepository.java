package com.doxito.game.afk.heroes.repositories;

import com.doxito.game.afk.heroes.models.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

    @Query(value = "select * from heroes as h where h.user_id =?1", nativeQuery = true)
    List<Hero> findAllByUserId(Long userId);
}
