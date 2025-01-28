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
   private final String role;

   @Override
   public boolean canRegisterTask() {
      return false;
   }

   @Override
   public boolean canObserveTask() {
      return false;
   }

   @Override
   public boolean canReceiveTaskNotification() {
      return false;
   }

   @Override
   public boolean canEditTask() {
      return false;
   }

   @Override
   public boolean canInviteUser() {
      return false;
   }

   @Override
   public boolean canEditUser() {
      return false;
   }

   @Override
   public boolean canDeleteUser() {
      // Your logic here
      return true; // Example
   }
   @Override
   public UserRole getRole() {
      // Replace with actual logic
      return UserRole.USER; // Example
   }
}
