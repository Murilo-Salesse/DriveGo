package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.core.entities.User;

import java.util.UUID;

public interface UserGateway {

    User createUser(User user);
    User findByEmail(String email);
    User findById(UUID id);
    User updateUser(User user);
}
