package com.example.CasaOrganizada.Registration;

import com.example.CasaOrganizada.Users.domain.AdminUser;
import com.example.CasaOrganizada.Users.domain.InvalidEmailFormatException;
import com.example.CasaOrganizada.Users.domain.User;
import com.example.CasaOrganizada.Users.domain.UserRole;
import com.example.CasaOrganizada.Users.repository.UserRepository;
import com.example.CasaOrganizada.Users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UserService userService;
    private UserRepository userRepository;
    private EmailValidator emailValidator;

    @Autowired
    public RegistrationService(UserService userService, UserRepository userRepository, EmailValidator emailValidator) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.emailValidator = emailValidator;
    }

    public ResponseEntity<String> register(RegistrationRequest request) {
        Boolean IsEmailValid = emailValidator.test(request.getEmail());
        if (!IsEmailValid) {
            throw new InvalidEmailFormatException("Email is not valid");
        }
        User user = new AdminUser(request.getName(), request.getEmail(),
        request.getPassword(), request.getConfirmPassword());
        UserRole userRole = request.getRole();
        user.setRole(userRole);
        userService.signUp(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
