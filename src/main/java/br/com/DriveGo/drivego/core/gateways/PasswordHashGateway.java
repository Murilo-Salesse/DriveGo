package br.com.DriveGo.drivego.core.gateways;

public interface PasswordHashGateway {
    String hash(String raw);
}
