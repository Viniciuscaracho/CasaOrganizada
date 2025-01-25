package com.example.CasaOrganizada.Registration;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
   private final String name;
   private final String phoneNumber;
   private final String password;
   private final String confirmPassword;
   private final String role;
}
