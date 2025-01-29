package com.example.CasaOrganizada.Users.services;

import com.example.CasaOrganizada.Registration.token.Token;
import com.example.CasaOrganizada.Registration.token.TokenService;
import com.example.CasaOrganizada.Users.domain.AdminUser;
import com.example.CasaOrganizada.Users.domain.User;
import com.example.CasaOrganizada.Users.domain.UserRole;
import com.example.CasaOrganizada.Users.domain.UserStatus;
import com.example.CasaOrganizada.Users.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private TokenService tokenService;

    public String registerUser(User user) {
        boolean userExists = userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent();
        if (userExists) {
            throw new EntityExistsException("User " + user.getPhoneNumber() + " already exists");
        }



        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        String token = UUID.randomUUID().toString();
        Token confirmationToken = new Token(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                user
        );

        tokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    private void verifyAdmin(User user) {
        if (!(user instanceof AdminUser)){
            throw new SecurityException("User " + user.getName() + " is not an AdminUser");
        }
    }

    public User inviteUser(User user) {
        user.setStatus(UserStatus.PENDING);
        user.setUserWasInvited(true);
        return userRepository.save(user);
    }

    public void activateUser(User user) {
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }

}