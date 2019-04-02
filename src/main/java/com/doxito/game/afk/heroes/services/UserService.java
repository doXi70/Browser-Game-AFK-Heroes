package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.models.dtos.ActiveSessionsDto;
import com.doxito.game.afk.heroes.models.dtos.EditUserProfileDto;
import com.doxito.game.afk.heroes.models.dtos.UserRegisterDto;
import com.doxito.game.afk.heroes.models.entities.User;

import java.util.List;

public interface UserService {

    void createNewUser(UserRegisterDto userRegisterDto);

    User findByEmail(String email);

    void save(User user);

    void editUser(EditUserProfileDto name, String principalName);

    List<User> findAll();

    List<User> findAllByEmail(List<String> emails);

    ActiveSessionsDto[] getAllActiveSessions();
}
