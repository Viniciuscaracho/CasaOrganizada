package com.example.CasaOrganizada.Users.domain;

public class GuestUser extends User {
    public GuestUser(String name, String phoneNumber, String password, String passwordConfirm) {
        super(name, phoneNumber, password, passwordConfirm);
        super.setRole(UserRole.GUEST);
    }
}
