package br.com.DriveGo.drivego.infrastructure.security;

import br.com.DriveGo.drivego.core.gateways.PasswordHashGateway;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordHashGateway implements PasswordHashGateway {

    private final PasswordEncoder passwordEncoder;

    public BCryptPasswordHashGateway(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String hash(String raw) {
        return passwordEncoder.encode(raw);
    }

    @Override
    public boolean matches(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}