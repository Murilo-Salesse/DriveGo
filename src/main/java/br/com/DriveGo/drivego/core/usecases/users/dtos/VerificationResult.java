package br.com.DriveGo.drivego.core.usecases.users.dtos;

import br.com.DriveGo.drivego.core.entities.User;

public class VerificationResult {

    private User user;

    public VerificationResult(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
