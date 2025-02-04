package com.example.CasaOrganizada.Users.services;

import com.example.CasaOrganizada.Registration.RegistrationRequest;
import com.example.CasaOrganizada.Users.domain.AdminUser;
import com.example.CasaOrganizada.Users.domain.User;
import com.example.CasaOrganizada.Users.domain.UserRole;
import com.example.CasaOrganizada.Users.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

//    public User inviteUser(String phoneNumber) {
//
//    }

    public User editUserByUserName(User user, String userName, String Email, UserRole role) {
        user.setName(userName);
        user.setEmail(Email);
        user.setRole(role);
        return userRepository.save(user);
    }
}
