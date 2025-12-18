package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.gateways.UserGateway;

public class LoginUserUseCaseImp implements LoginUserUseCase{

    private final UserGateway userGateway;

    public LoginUserUseCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        return userGateway.loginUser(user);
    }
}
