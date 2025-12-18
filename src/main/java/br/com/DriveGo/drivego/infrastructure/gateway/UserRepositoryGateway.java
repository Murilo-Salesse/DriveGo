package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.gateways.EmailGateway;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.core.usecases.email.SendVerificationEmailUseCase;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;
import br.com.DriveGo.drivego.infrastructure.exceptions.UnauthorizedException;
import br.com.DriveGo.drivego.infrastructure.mappers.UserEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.UserEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRepositoryGateway(UserRepository userRepository, EmailGateway emailGateway, SendVerificationEmailUseCase sendVerificationEmailUseCase, EmailGateway emailGateway1, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);


        return UserEntityMapper.toDomain(
                userRepository.save(UserEntityMapper.toEntity(user)));
    }

    @Override
    public User loginUser(User user) {
        UserEntity userFound = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado com o email: " + user.getEmail()));

        if (!passwordEncoder.matches(user.getPasswordHash(), user.getPasswordHash())) {
            throw new UnauthorizedException("Email ou Senha incorretos.");
        }

        return UserEntityMapper.toDomain(userFound);
    }
}
