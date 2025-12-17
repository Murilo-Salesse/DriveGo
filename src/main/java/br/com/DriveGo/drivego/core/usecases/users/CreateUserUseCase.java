package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;

public interface CreateUserUseCase {

    User execute(User user);
}
