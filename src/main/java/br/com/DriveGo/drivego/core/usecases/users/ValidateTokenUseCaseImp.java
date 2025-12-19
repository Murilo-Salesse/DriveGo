package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.enums.UserStatus;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.VerificationResponse;
import br.com.DriveGo.drivego.infrastructure.exceptions.InvalidTokenException;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;

import java.time.LocalDateTime;

public class ValidateTokenUseCaseImp implements ValidateTokenUseCase {

    private final UserGateway userGateway;

    public ValidateTokenUseCaseImp(
            UserGateway userGateway
    ) {
        this.userGateway = userGateway;
    }

    @Override
    public VerificationResponse execute(String email, String verificationCode) {
        User user = userGateway.findByEmail(email);

        validateUserExists(user, email);
        validateTokenMatches(user, verificationCode);
        validateTokenNotExpired(user);
        validateUserHasRole(user);

        user.setStatus(UserStatus.ACTIVE);
        user.setVerificationCode(null);
        user.setVerificationExpiresAt(null);

        User activatedUser = userGateway.updateUser(user);

        return new VerificationResponse(activatedUser);
    }

    private void validateUserExists(User user, String email) {
        if (user == null) {
            throw new NotFoundException("Usuário não encontrado com email: " + email);
        }
    }

    private void validateTokenMatches(User user, String verificationCode) {
        if (!verificationCode.equals(user.getVerificationCode())) {
            throw new InvalidTokenException("Código de verificação inválido");
        }
    }

    private void validateTokenNotExpired(User user) {
        if (user.getVerificationExpiresAt().isBefore(LocalDateTime.now())) {
            throw new InvalidTokenException("Código de verificação expirado");
        }
    }

    private void validateUserHasRole(User user) {
        if (user.getRole() == null) {
            throw new InvalidTokenException("Usuário sem role definida");
        }
    }
}