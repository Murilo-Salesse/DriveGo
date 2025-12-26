package br.com.DriveGo.drivego.infrastructure.gateway;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.infrastructure.mappers.UserEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.UserEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.UserRepository;


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

        if (user.getFullName() != null) existingEntity.setFullName(user.getFullName());
        if (user.getPhone() != null) existingEntity.setPhone(user.getPhone());
        if (user.getStatus() != null) existingEntity.setStatus(user.getStatus());
        if (user.getVerificationCode() != null) existingEntity.setVerificationCode(user.getVerificationCode());
        if (user.getVerificationExpiresAt() != null) existingEntity.setVerificationExpiresAt(user.getVerificationExpiresAt());

        UserEntity savedEntity = userRepository.save(existingEntity);

        return UserEntityMapper.toDomain(savedEntity);
    }
}

