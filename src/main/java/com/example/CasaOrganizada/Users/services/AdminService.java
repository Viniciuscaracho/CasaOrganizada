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

    public AdminUser createAdmin(AdminUser admin) {
        admin.setRole(UserRole.ADMIN);
        return userRepository.save(admin);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User editUserByUserName(User user) {
        user.setName(user.getName());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setRole(UserRole.ADMIN);
        return userRepository.save(user);
    }
}