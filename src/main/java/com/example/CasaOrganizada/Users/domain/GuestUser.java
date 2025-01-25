package com.example.CasaOrganizada.Users.domain;

public class GuestUser extends User {
    public GuestUser(String name, String phoneNumber, String password, String passwordConfirm) {
        super(name, phoneNumber, password, passwordConfirm);
    }

    @Override
    public boolean canRegisterTask() {
        return true;
    }

    @Override
    public boolean canObserveTask() {
        return true;
    }

    @Override
    public boolean canReceiveTaskNotification() {
        return true;
    }

    @Override
    public boolean canEditTask() {
        return true;
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
        return false;
    }

}
