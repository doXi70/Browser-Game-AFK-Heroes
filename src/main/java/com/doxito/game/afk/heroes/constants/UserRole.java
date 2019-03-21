package com.doxito.game.afk.heroes.constants;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("ROLE_USER"),
    MAINTAINER("ROLE_MAINTAINER"),
    ADMIN("ROLE_ADMIN");

    private String name;

    UserRole(String name) {
        this.name = name;
    }
}
