package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.models.dtos.UserRegisterDto;
import com.doxito.game.afk.heroes.models.entities.Role;
import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.repositories.RoleRepository;
import com.doxito.game.afk.heroes.repositories.UserRepository;
import com.doxito.game.afk.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(userEmail);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid User");
        } else {
            Set<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toSet());

            return new org.springframework.security.core.
                    userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
        }
    }

    @Override
    public void createNewUser(UserRegisterDto userRegisterDto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User(userRegisterDto.getEmail(), userRegisterDto.getUsername(), bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));
        Role userRole = this.roleRepository.findByName("ROLE_USER");
        user.addRole(userRole);
        this.userRepository.saveAndFlush(user);
    }
}
