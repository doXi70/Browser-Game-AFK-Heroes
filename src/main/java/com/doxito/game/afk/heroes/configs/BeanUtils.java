package com.doxito.game.afk.heroes.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BeanUtils {

    @Bean
    public BCryptPasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
