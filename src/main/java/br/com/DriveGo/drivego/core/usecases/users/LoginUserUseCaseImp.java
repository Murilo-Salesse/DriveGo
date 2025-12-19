package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.enums.UserStatus;
import br.com.DriveGo.drivego.core.gateways.JwtTokenGateway;
import br.com.DriveGo.drivego.core.gateways.PasswordHashGateway;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.LoginResponse;
import br.com.DriveGo.drivego.infrastructure.exceptions.InvalidCredentialsException;

public class LoginUserUseCaseImp implements LoginUserUseCase {

    private final UserGateway userGateway;
    private final JwtTokenGateway jwtTokenGateway;
    private final PasswordHashGateway passwordHashGateway;

    public LoginUserUseCaseImp(
            UserGateway userGateway,
            JwtTokenGateway jwtTokenGateway,
            PasswordHashGateway passwordHashGateway
    ) {
        this.userGateway = userGateway;
        this.jwtTokenGateway = jwtTokenGateway;
        this.passwordHashGateway = passwordHashGateway;
    }

    @Override
    public LoginResponse execute(String email, String password) {
        User user = userGateway.findByEmail(email);

        validateUserExists(user, email);
        validatePasswordMatches(user, password);
        validateUserIsActive(user);

        String token = jwtTokenGateway.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new LoginResponse(token, user);
    }

    private void validateUserExists(User user, String email) {
        if (user == null) {
            throw new InvalidCredentialsException("Email ou senha inválidos");
        }
    }

    private void validatePasswordMatches(User user, String rawPassword) {
        if (!passwordHashGateway.matches(rawPassword, user.getPasswordHash())) {
            throw new InvalidCredentialsException("Email ou senha inválidos");
        }
    }

    private void validateUserIsActive(User user) {
        if (user.getStatus() != UserStatus.ACTIVE) {
            throw new InvalidCredentialsException("Usuário não está ativo. Verifique seu email.");
        }
    }
}
