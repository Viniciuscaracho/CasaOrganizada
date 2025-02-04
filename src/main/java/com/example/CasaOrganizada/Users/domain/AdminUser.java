package com.example.CasaOrganizada.Users.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminUser extends User {
    public AdminUser(String name,String Email,String password, String passwordConfirm) {
        super(name, Email, password, passwordConfirm);
        UserRole role = UserRole.ADMIN;
        super.setRole(role);
   }

    public AdminUser() {

    }

    public boolean isAdmin() {
        return true;
   }
}
