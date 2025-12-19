package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.core.enums.Roles;

import java.util.UUID;

public interface JwtTokenGateway {

    String generateToken(UUID userId, String email, Roles role);
    String getEmail(String token);
    boolean isValid(String token);
}
