package br.com.DriveGo.drivego.infrastructure.security;

import br.com.DriveGo.drivego.core.gateways.PasswordHashGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordHashGateway implements PasswordHashGateway {

    private final PasswordEncoder passwordEncoder;

    public BCryptPasswordHashGateway(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String hash(String raw) {
        return passwordEncoder.encode(raw);
    }
}