package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.services.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper {

    private final ModelMapper modelMapper;

    public MapperImpl() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }

    @Override
    public void map(Object source, Object destination) {
        modelMapper.map(source, destination);
    }
}
