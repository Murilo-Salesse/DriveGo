package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.infrastructure.mappers.UserEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.UserEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;

    public UserRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return UserEntityMapper.toDomain(
                userRepository.save(
                        UserEntityMapper.toEntity(user)
                )
        );
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id)
                .map(UserEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public User updateUser(User user) {
        UserEntity existingEntity = userRepository.findById(user.getId())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        existingEntity.setStatus(user.getStatus());
        existingEntity.setVerificationCode(user.getVerificationCode());
        existingEntity.setVerificationExpiresAt(user.getVerificationExpiresAt());

        UserEntity savedEntity = userRepository.save(existingEntity);

        return UserEntityMapper.toDomain(savedEntity);
    }
}

