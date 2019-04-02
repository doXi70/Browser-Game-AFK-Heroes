package com.doxito.game.afk.heroes.services;

public interface Mapper {

    <S, D> D convert(S source, Class<D> destinationClass);

    void map(Object source, Object destination);
}
