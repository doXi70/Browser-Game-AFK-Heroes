package com.doxito.game.afk.heroes.repositories;

import com.doxito.game.afk.heroes.models.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

}
