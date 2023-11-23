package com.julioluis.amystudio.services;

import com.julioluis.amystudio.entities.Authority;
import com.julioluis.amystudio.entities.Rol;
import com.julioluis.amystudio.entities.Users;
import com.julioluis.amystudio.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository userRepository;

    private Users user;

    @Before
    public void init() {
        user=new Users();
        user.setId(1L);
        user.setEmail("email@example.com");
        user.setPassword("password");

        Rol rol=new Rol();
        rol.setId(1L);
        rol.setRolName("ADMIN");

        Set<Authority> authorities=new HashSet<>();
        Authority authority=new Authority();
        authority.setAuthName("agenda");
        authorities.add(authority);

        rol.setAuthorities(authorities);

        user.setRol(rol);


    }

    @Test
    public void test_find_user_by_email() {
        String email="email@example.com";
        when(userRepository.findByEmail(anyString())).thenReturn(user);

        Users userdb=service.findUserByEmail(email);
        assertEquals(email,userdb.getEmail());

        verify(userRepository,times(1)).findByEmail(anyString());
    }
}
