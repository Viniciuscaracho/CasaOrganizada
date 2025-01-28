package com.example.CasaOrganizada.Registration;

import com.example.CasaOrganizada.Users.domain.AdminUser;
import com.example.CasaOrganizada.Users.domain.User;
import com.example.CasaOrganizada.Users.repository.UserRepository;
import com.example.CasaOrganizada.Users.services.UserService;

public class RegistrationService {
    private UserService userService;
    private UserRepository userRepository;

    public String register(RegistrationRequest request) {
        User user = new AdminUser(request.getName(), request.getPhoneNumber(),
                request.getPassword(), request.getConfirmPassword());
        userService.registerUser(user);
        return "";
    }
}
