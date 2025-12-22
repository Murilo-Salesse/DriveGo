package br.com.DriveGo.drivego.core.usecases.users.dtos;

import br.com.DriveGo.drivego.core.entities.User;

public class LoginResult {

    private final User user;

    public LoginResult(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
