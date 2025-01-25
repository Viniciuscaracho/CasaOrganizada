package com.example.CasaOrganizada.Users.services;

import com.example.CasaOrganizada.Registration.RegistrationRequest;
import com.example.CasaOrganizada.Users.domain.User;
import com.example.CasaOrganizada.Users.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private User user;
    public void registerUser(User user) {

    }
}