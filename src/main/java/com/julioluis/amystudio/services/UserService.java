package com.julioluis.amystudio.services;

import com.julioluis.amystudio.entities.Users;
import com.julioluis.amystudio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Users findUserByEmail(String email) {
        Users user=userRepository.findByEmail(email);
        return user;
    }
}
