package com.example.CasaOrganizada.Registration;

import com.example.CasaOrganizada.Users.domain.User;
import com.example.CasaOrganizada.Users.domain.UserRole;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest extends User {
   private final String name;
   private final String phoneNumber;
   private final String password;
   private final String confirmPassword;
   private final UserRole role;
}
