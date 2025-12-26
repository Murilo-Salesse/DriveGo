package br.com.DriveGo.drivego.core.usecases.users;

import java.util.UUID;

import br.com.DriveGo.drivego.core.entities.User;

public interface UpdateUserUseCase {
    User execute(UUID id, User user);
}
