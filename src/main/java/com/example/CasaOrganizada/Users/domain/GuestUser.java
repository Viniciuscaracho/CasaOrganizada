package com.example.CasaOrganizada.Users.domain;

public class GuestUser extends User {
    public GuestUser(String name, String Email, String password, String passwordConfirm) {
        super(name, Email, password, passwordConfirm);
        super.setRole(UserRole.GUEST);
    }
}
