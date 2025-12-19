package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.enums.Roles;
import br.com.DriveGo.drivego.core.enums.UserStatus;
import br.com.DriveGo.drivego.core.gateways.PasswordHashGateway;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.core.usecases.email.SendVerificationEmailUseCase;
import br.com.DriveGo.drivego.infrastructure.exceptions.DuplicateException;

import java.time.LocalDateTime;

public class CreateUserUseCaseImp implements CreateUserUseCase{


    private final UserGateway userGateway;
    private final PasswordHashGateway passwordHashGateway;
    private final SendVerificationEmailUseCase sendVerificationEmailUseCase;

    public CreateUserUseCaseImp(
            UserGateway userGateway,
            PasswordHashGateway passwordHashGateway,
            SendVerificationEmailUseCase sendVerificationEmailUseCase
    ) {
        this.userGateway = userGateway;
        this.passwordHashGateway = passwordHashGateway;
        this.sendVerificationEmailUseCase = sendVerificationEmailUseCase;
    }

    @Override
    public User execute(User user) {
        if (userGateway.findByEmail(user.getEmail()) != null) {
            throw new DuplicateException("Email já cadastrado");
        }

        user.setPasswordHash(passwordHashGateway.hash(user.getPasswordHash()));
        user.setStatus(UserStatus.PENDING);

        if (user.getRole() == null) {
            user.setRole(Roles.CLIENT);
        }

        String code = String.valueOf((int)(Math.random() * 900000) + 100000);
        user.setVerificationCode(code);
        user.setVerificationExpiresAt(LocalDateTime.now().plusMinutes(5));

        User savedUser = userGateway.createUser(user);

        sendVerificationEmailUseCase.execute(savedUser.getEmail(), code);

        return savedUser;
    }
}
