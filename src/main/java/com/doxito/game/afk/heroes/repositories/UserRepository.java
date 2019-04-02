package com.doxito.game.afk.heroes.repositories;

import com.doxito.game.afk.heroes.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByEmailIsIn(List<String> emails);
}
