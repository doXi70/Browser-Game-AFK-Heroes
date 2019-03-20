package com.doxito.game.afk.heroes.services;

import com.doxito.game.afk.heroes.models.dtos.UserRegisterDto;

public interface UserService {

    void createNewUser(UserRegisterDto userRegisterDto);
}
