package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.infrastructure.mappers.UserEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.UserRepository;
import org.springframework.stereotype.Component;


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
}

