package br.com.DriveGo.drivego.core.usecases.users;

import java.util.UUID;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.gateways.UserGateway;

public class UpdateUserUseCaseImp implements UpdateUserUseCase {

    private final UserGateway userGateway;

    public UpdateUserUseCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(UUID id, User user) {
        user.setId(id);
        return userGateway.updateUser(user);
    }
}
