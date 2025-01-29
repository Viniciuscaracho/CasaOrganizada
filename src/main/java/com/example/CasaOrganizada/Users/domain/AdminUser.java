package com.example.CasaOrganizada.Users.domain;

public class AdminUser extends User {
    public AdminUser(String name,String phoneNumber,String password, String passwordConfirm) {
        super(name, phoneNumber, password, passwordConfirm);
        UserRole role = UserRole.ADMIN;
        super.setRole(role);
   }

   public boolean isAdmin() {
        return true;
   }
}
