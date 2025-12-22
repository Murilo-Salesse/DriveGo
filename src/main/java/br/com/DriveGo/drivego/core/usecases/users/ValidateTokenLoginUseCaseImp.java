package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.exceptions.InvalidTokenException;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.core.gateways.JwtTokenGateway;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.core.usecases.users.dtos.VerificationLoginResult;

import java.time.LocalDateTime;

public class ValidateTokenLoginUseCaseImp implements ValidateTokenLoginUseCase {

    private final UserGateway userGateway;
    private final JwtTokenGateway jwtTokenGateway;

    public ValidateTokenLoginUseCaseImp(UserGateway userGateway, JwtTokenGateway jwtTokenGateway) {
        this.userGateway = userGateway;
        this.jwtTokenGateway = jwtTokenGateway;
    }

    @Override
    public VerificationLoginResult execute(String email, String verificationCode) {
        User user = userGateway.findByEmail(email);

        validateUserExists(user);
        validateLoginCode(user, verificationCode);
        validateCodeNotExpired(user);

        String token = jwtTokenGateway.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        user.setVerificationCode(null);
        user.setVerificationExpiresAt(null);
        user.setLastLoginAt(LocalDateTime.now());

        userGateway.updateUser(user);

        return new VerificationLoginResult(token, user);
    }

    private void validateUserExists(User user) {
        if (user.getEmail() == null) {
            throw new NotFoundException("Usuário não encontrado com email: " + user.getEmail());
        }
    }

    private void validateLoginCode(User user, String verificationCode) {
        if (!verificationCode.equals(user.getVerificationCode())) {
            throw new InvalidTokenException("Código de verificação inválido");
        }
    }

    private void validateCodeNotExpired(User user) {
        if (user.getVerificationExpiresAt().isBefore(LocalDateTime.now())) {
            throw new InvalidTokenException("Código de verificação expirado");
        }
    }
}


