package com.doxito.game.afk.heroes.services;


public interface ValidationUtil {

    <T> boolean isValid(T object);

    <T> String getViolationMessage(T object);
}
