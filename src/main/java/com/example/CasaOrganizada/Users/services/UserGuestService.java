package com.example.CasaOrganizada.Users.services;

import com.example.CasaOrganizada.Users.domain.User;
import com.example.CasaOrganizada.Users.domain.UserStatus;
import com.example.CasaOrganizada.Users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGuestService {

    @Autowired
    private UserRepository userRepository;

    public User inviteUser(User user) {
        user.setStatus(UserStatus.PENDING);
        return userRepository.save(user);
    }

    public void activateUser(User user) {
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }


}