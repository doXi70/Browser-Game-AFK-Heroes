package com.doxito.game.afk.heroes.services.impl;

import com.doxito.game.afk.heroes.constants.UserRole;
import com.doxito.game.afk.heroes.models.dtos.ActiveSessionsDto;
import com.doxito.game.afk.heroes.models.dtos.EditUserProfileDto;
import com.doxito.game.afk.heroes.models.dtos.UserRegisterDto;
import com.doxito.game.afk.heroes.models.entities.Role;
import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.repositories.HeroRepository;
import com.doxito.game.afk.heroes.repositories.RoleRepository;
import com.doxito.game.afk.heroes.repositories.UserRepository;
import com.doxito.game.afk.heroes.services.Mapper;
import com.doxito.game.afk.heroes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HeroRepository heroRepository;
    private final Mapper mapper;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           HeroRepository heroRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.heroRepository = heroRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = findByEmail(userEmail);

        Set<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.
                userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }

    @Override
    public void createNewUser(UserRegisterDto userRegisterDto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User(userRegisterDto.getEmail(), userRegisterDto.getUsername(), bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));
        Role userRole = this.roleRepository.findByName(UserRole.USER.getName());
        user.addRole(userRole);
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
//        user.setLastLogin(now);
        this.userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void editUser(EditUserProfileDto newUserData, String principalName) {
        User oldUserData = this.findByEmail(principalName);
        //TODO: validate

        if (!newUserData.getPassword().equals(newUserData.getConfirmPassword())) {
            return;
        }

        oldUserData.setEmail(newUserData.getEmail());
        oldUserData.setFirstName(newUserData.getFirstName());
        oldUserData.setLastName(newUserData.getLastName());
        oldUserData.setUsername(newUserData.getUsername());
        oldUserData.setPassword(new BCryptPasswordEncoder().encode(newUserData.getPassword()));
        this.userRepository.save(oldUserData);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> findAllByEmail(List<String> emails) {
        return this.userRepository.findAllByEmailIsIn(emails);
    }

    @Override
    public ActiveSessionsDto[] getAllActiveSessions() {
        List<String> emails = this.sessionRegistry.getAllPrincipals().stream()
                .filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                .map(user -> ((UserDetails) user).getUsername())
                .collect(Collectors.toList());

        return mapper.convert(findAllByEmail(emails), ActiveSessionsDto[].class);
    }

    @Override
    public void changeRole(Long userId) {
        User user = this.userRepository.findOne(userId);

        Role role = user.getRoles().iterator().next();

        Role newRole;
        if (role.getName().equals(UserRole.ADMIN.getName())) {
            newRole = this.roleRepository.findByName(UserRole.USER.getName());
        } else {
            newRole = this.roleRepository.findByName(UserRole.ADMIN.getName());
        }

        user.removeRole(role);
        user.addRole(newRole);
        this.userRepository.save(user);
    }
}
