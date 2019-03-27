package com.doxito.game.afk.heroes.models.entities;

import com.doxito.game.afk.heroes.constants.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
        this.users = new HashSet<>();
    }

    public Role(UserRole role) {
        this();
        this.name = role.getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
