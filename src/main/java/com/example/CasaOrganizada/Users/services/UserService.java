package com.example.CasaOrganizada.Users.services;

import com.example.CasaOrganizada.Registration.Token.ConfirmationToken;
import com.example.CasaOrganizada.Registration.Token.ConfirmationTokenService;
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
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    public String signUp(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists) {
            throw new EntityExistsException("User " + user.getEmail() + " already exists");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setStatus(UserStatus.PENDING);

        UserRole userRole = user.getRoleInvitation();
        user.setRole(userRole);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);



        return "";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
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