package com.doxito.game.afk.heroes.models.entities;

import com.doxito.game.afk.heroes.constants.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles")
    private Set<Role> roles;


    public User() {
        this.roles = new HashSet<>();
    }

    public User(String email, String username, String password) {
        this();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Transactional
    public boolean isAdmin() {
        return this.roles.stream().anyMatch(r -> r.getName().equals(UserRole.ADMIN.getName()));
    }
}
