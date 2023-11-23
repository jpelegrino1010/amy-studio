package com.julioluis.amystudio.config;


import com.julioluis.amystudio.entities.Rol;
import com.julioluis.amystudio.entities.Users;
import com.julioluis.amystudio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AmyStudioProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email=authentication.getName();
        String password=authentication.getCredentials().toString();

        Users loginUser=userService.findUserByEmail(email);

        if(Objects.nonNull(loginUser)
        && passwordEncoder.matches(password,loginUser.getPassword())) {
            return  new UsernamePasswordAuthenticationToken(loginUser.getEmail(),loginUser.getPassword(),
                    getGrantedAuthorities(loginUser.getRol()));
        }


        return null;
    }

    private Set<? extends GrantedAuthority> getGrantedAuthorities(Rol rol) {
        final Set<GrantedAuthority> authorities=new HashSet<>();
        rol.getAuthorities().stream().forEach(authority -> {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
        });
        return authorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
