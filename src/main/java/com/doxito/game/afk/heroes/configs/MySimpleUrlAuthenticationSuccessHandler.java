package com.doxito.game.afk.heroes.configs;

import com.doxito.game.afk.heroes.models.entities.User;
import com.doxito.game.afk.heroes.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@Component
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

//    @Autowired
//    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        UserDetails principal = (UserDetails) authentication.getPrincipal();
        setLastLogin(principal);

        redirectStrategy.sendRedirect(request, response, "/dashboard");
    }

    private void setLastLogin(UserDetails principal) {
//        User user = userService.findByEmail(principal.getUsername());
//        user.setLastLogin(LocalDateTime.now(ZoneOffset.UTC));

//        log.info("User with email {} and roles: {} logged in!",
//                user.getEmail(), StringUtils.collectionToCommaDelimitedString(principal.getRoles()));

//        this.userService.save(user);
    }
}
