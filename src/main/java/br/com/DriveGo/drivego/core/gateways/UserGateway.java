package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.core.entities.User;

public interface UserGateway {

    User createUser(User user);
    User loginUser(User user);
}
