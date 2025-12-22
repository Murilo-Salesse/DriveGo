package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.enums.UserStatus;
import br.com.DriveGo.drivego.core.gateways.JwtTokenGateway;
import br.com.DriveGo.drivego.core.gateways.PasswordHashGateway;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.core.usecases.email.SendVerifiyLoginEmailUseCase;

import br.com.DriveGo.drivego.core.usecases.users.dtos.LoginResult;
import br.com.DriveGo.drivego.core.exceptions.InvalidCredentialsException;

import java.time.LocalDateTime;

public class LoginUserUseCaseImp implements LoginUserUseCase {

    private final UserGateway userGateway;
    private final PasswordHashGateway passwordHashGateway;
    private final SendVerifiyLoginEmailUseCase sendVerifiyLoginEmailUseCase;

    public LoginUserUseCaseImp(
            UserGateway userGateway,
            PasswordHashGateway passwordHashGateway,
            SendVerifiyLoginEmailUseCase sendVerifiyLoginEmailUseCase
    ) {
        this.userGateway = userGateway;
        this.passwordHashGateway = passwordHashGateway;
        this.sendVerifiyLoginEmailUseCase = sendVerifiyLoginEmailUseCase;
    }

    public LoginResult execute(String email, String password) {
        User user = userGateway.findByEmail(email);

        validateUserExists(user, email);
        validatePasswordMatches(user, password);
        validateUserIsActive(user);

        String code = String.valueOf((int)(Math.random() * 900000) + 100000);
        user.setVerificationCode(code);
        user.setVerificationExpiresAt(LocalDateTime.now().plusMinutes(5));

        userGateway.updateUser(user);
        sendVerifiyLoginEmailUseCase.execute(user.getEmail(), code);

        return new LoginResult(user);
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
