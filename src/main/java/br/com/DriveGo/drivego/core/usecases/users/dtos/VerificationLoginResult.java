package br.com.DriveGo.drivego.core.usecases.users.dtos;

import br.com.DriveGo.drivego.core.entities.User;

public class VerificationLoginResult {

    private final String token;
    private final User user;

    public VerificationLoginResult(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }
}
