package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.gateways.UserGateway;

public class CreateUserUseCaseImp implements CreateUserUseCase{

    private final UserGateway userGateway;

    public CreateUserUseCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        return userGateway.createUser(user);
    }
}
